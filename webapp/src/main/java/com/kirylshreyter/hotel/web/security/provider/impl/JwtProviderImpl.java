package com.kirylshreyter.hotel.web.security.provider.impl;

import com.kirylshreyter.hotel.web.security.provider.JwtProvider;
import com.kirylshreyter.hotel.services.config.ApplicationProperties;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.kirylshreyter.hotel.services.logging.Jwt.*;

@Component
public final class JwtProviderImpl implements JwtProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProviderImpl.class);

    @Inject
    private ApplicationProperties applicationProperties;

    @Override
    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, applicationProperties.getJwtSecret())
                .compact();
    }

    @Override
    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(applicationProperties.getJwtSecret()).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expiredJwtException) {
            LOGGER.info(TOKEN_EXPIRED);
        } catch (UnsupportedJwtException unsupportedJwtException) {
            LOGGER.info(UNSUPPORTED_JWT);
        } catch (MalformedJwtException malformedJwtException) {
            LOGGER.info(MALFORMED_JWT);
        } catch (SignatureException signatureException) {
            LOGGER.info(INVALID_SIGNATURE);
        } catch (Exception exception) {
            LOGGER.info(INVALID_TOKEN);
        }
        return false;
    }

    @Override
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(applicationProperties.getJwtSecret()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    @Override
    public boolean isInvalidToken(String token) {
        return !isValidToken(token);
    }
}