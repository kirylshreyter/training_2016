package com.kirylshreyter.hotel.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public class TokenAuthentication implements Authentication {
    private String token;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAuthenticated;
    private UserDetails principal;
    private HttpServletRequest request;

    public TokenAuthentication(String token, HttpServletRequest request) {
        this.token = token;
        this.request = request;
    }

    public TokenAuthentication(String token,
                               Collection<? extends GrantedAuthority> authorities,
                               boolean isAuthenticated,
                               UserDetails principal) {
        this.token = token;
        this.authorities = authorities;
        this.isAuthenticated = isAuthenticated;
        this.principal = principal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return this.request;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        if (principal == null) return null;

        return principal.getUsername();
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    public String getToken() {
        return token;
    }
}
