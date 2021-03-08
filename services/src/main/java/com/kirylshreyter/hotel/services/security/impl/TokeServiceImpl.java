package com.kirylshreyter.hotel.services.security.impl;

import com.kirylshreyter.hotel.datamodel.User;
import com.kirylshreyter.hotel.services.UserService;
import com.kirylshreyter.hotel.services.config.ApplicationProperties;
import com.kirylshreyter.hotel.services.security.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokeServiceImpl implements TokenService {
    @Inject
    private UserService userService;

    @Inject
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Inject
    private ApplicationProperties applicationProperties;

    @Override
    public String getToken(String email, String password) throws RuntimeException {
        if (email == null || email.length() == 0) throw new RuntimeException("Email is empty");
        if (password == null || password.length() == 0) throw new RuntimeException("Password is empty");

        User user = userService.findByEmail(email);
        if (user == null) throw new RuntimeException("User not found");
        String pass = bCryptPasswordEncoder.encode(password);

        if (!user.getEncryptedPassword().equals(pass)) throw new RuntimeException("Authentication failed");
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put("clientType", "user");
        tokenData.put("userID", user.getId());
        tokenData.put("username", user.getEmail());
        tokenData.put("token_create_date", new Date().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 100);
        tokenData.put("token_expiration_date", calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, applicationProperties.getJwtSecret()).compact();
    }
}
