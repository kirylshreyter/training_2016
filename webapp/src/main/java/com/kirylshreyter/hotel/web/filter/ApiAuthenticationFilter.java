package com.kirylshreyter.hotel.web.filter;

import com.kirylshreyter.hotel.services.AuthenticationService;
//import com.kirylshreyter.hotel.services.security.Authentication;
import com.kirylshreyter.hotel.web.config.Constants;
import com.kirylshreyter.hotel.web.config.Permissions;
import com.kirylshreyter.hotel.web.security.TokenAuthentication;
import com.kirylshreyter.hotel.web.security.manager.TokenAuthenticationManager;
import com.kirylshreyter.hotel.web.security.provider.JwtProvider;
import com.kirylshreyter.hotel.web.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.jsonwebtoken.lang.Strings.hasText;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class ApiAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//    @Inject
//    private AuthenticationService authService;

//    @Inject
//    private JwtProvider jwtProvider;

    @Inject
    private TokenAuthenticationManager tokenAuthenticationManager;

    private static final String BEARER_PREFIX = "Bearer ";

    public ApiAuthenticationFilter() {
        super("/api/**");
        setAuthenticationSuccessHandler((request, response, authentication) ->
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getRequestDispatcher(request.getServletPath() + request.getPathInfo()).forward(request, response);
        });
        setAuthenticationFailureHandler((request, response, authenticationException) -> {
            response.getOutputStream().print(authenticationException.getMessage());
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String token = getTokenFromRequest(request);
        if (token == null) {
            return new TokenAuthentication(null, null, false, null);
        }
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token, request);
        setAuthenticationManager(tokenAuthenticationManager);
        return getAuthenticationManager().authenticate(tokenAuthentication);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }




//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        if (jwtProvider != null) return;
//
//        ServletContext servletContext = filterConfig.getServletContext();
//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        if (webApplicationContext == null) return;
//
//        jwtProvider = webApplicationContext.getBean(JwtProvider.class);
//    }

//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        String token = getTokenFromRequest(httpRequest);
//
//        if (token == null || jwtProvider.isInvalidToken(token)) {
//            ((HttpServletResponse) response).setStatus(HttpStatus.UNAUTHORIZED.value());
//            return;
//        }
//
//        Authentication auth = authService.authenticate(token);
//        if (!auth.isAuthenticated()) {
//            ResponseUtils.getInstance().unauthorizedResponse(response, false);
//            return;
//        }
//        chain.doFilter(request, response);
//    }



////    public void destroy() {
////    }
////
    private String getTokenFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (hasText(authorizationHeader) && authorizationHeader.startsWith(BEARER_PREFIX)) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
//
//    private boolean preflightHostRequest(HttpServletRequest request) {
//        return request.getMethod().equals(Constants.OPTIONS_REQUEST_METHOD) && request.getHeader(Constants.ORIGIN_HEADER).equals(Permissions.CORS_ORIGIN_URI);
//    }
}
