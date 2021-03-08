package com.kirylshreyter.hotel.web.security.provider;

public interface JwtProvider {
    String generateToken(String login);

    boolean isValidToken(String token);

    String getEmailFromToken(String token);

    boolean isInvalidToken(String token);
}
