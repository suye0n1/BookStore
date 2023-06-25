package com.suyeon.bookstore.jwt;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import java.util.Collections;

@Getter
public class JwtAuthenticationBefore extends AbstractAuthenticationToken {
    private final String accessToken;

    public JwtAuthenticationBefore(String accessToken) {
        super(Collections.emptyList());
        this.accessToken = accessToken;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
