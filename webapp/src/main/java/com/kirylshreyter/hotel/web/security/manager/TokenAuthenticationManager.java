package com.kirylshreyter.hotel.web.security.manager;

import com.kirylshreyter.hotel.services.UserService;
import com.kirylshreyter.hotel.services.config.ApplicationProperties;
import com.kirylshreyter.hotel.web.security.TokenAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

@Service
public class TokenAuthenticationManager implements AuthenticationManager {
    @Inject
    private UserService userService;

    private UserDetailsService userDetailsService;

    @Inject
    private ApplicationProperties applicationProperties;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof TokenAuthentication)
            return processAuthentication((TokenAuthentication) authentication);

        authentication.setAuthenticated(false);
        return authentication;
    }

    private TokenAuthentication processAuthentication(TokenAuthentication authentication) throws AuthenticationException {
        String token = authentication.getToken();
        String key = applicationProperties.getJwtSecret();
        DefaultClaims claims;
        try {
            claims = (DefaultClaims) Jwts.parser().setSigningKey(key).parse(token).getBody();
        } catch (Exception ex) {
            throw new AuthenticationServiceException("Token corrupted");
        }
        if (claims.get("TOKEN_EXPIRATION_DATE", Long.class) == null)
            throw new AuthenticationServiceException("Invalid token");
        Date expiredDate = new Date(claims.get("TOKEN_EXPIRATION_DATE", Long.class));
        if (expiredDate.after(new Date()))
            return buildFullTokenAuthentication(authentication, claims);
        else
            throw new AuthenticationServiceException("Token expired date error");
    }

    private TokenAuthentication buildFullTokenAuthentication(TokenAuthentication authentication, DefaultClaims claims) {
        UserDetails user = userDetailsService.loadUserByUsername(claims.get("USERNAME", String.class));
        if (!user.isEnabled()) throw new AuthenticationServiceException("User disabled");

        return new TokenAuthentication(authentication.getToken(), user.getAuthorities(), true, user);


//        User user = userService.findByEmail(claims.get("USERNAME", String.class));
//        if (!user.getEnabled()) throw new AuthenticationServiceException("User disabled");
//        UserDetailsImpl userDetails = new UserDetailsImpl();
//
////        Collection<GrantedAuthority> authorities = userDetails.getAuthorities();
//        return new TokenAuthentication(authentication.getToken(), null, true, new UserDetailsImpl());
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
