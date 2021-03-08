package com.kirylshreyter.hotel.services.security;

public interface TokenService {
    String getToken(String email, String password) throws RuntimeException;
}
