package com.kirylshreyter.hotel.services;

import com.kirylshreyter.hotel.services.security.Authentication;
import com.kirylshreyter.hotel.services.security.Credentials;

public interface AuthenticationService {

    Authentication authenticate(Credentials credentials);

    Authentication authenticate(String token);

    Credentials resolveCredentials(String base64encodedString);

    boolean nullifyAuthentication(String token);

    String generateToken();

    String generateToken(String passPhrase);

}
