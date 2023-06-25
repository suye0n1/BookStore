package com.suyeon.bookstore.jwt;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Getter
public class JwtAuthenticationAfter extends AbstractAuthenticationToken {

    private Long memberId;
    public JwtAuthenticationAfter(Long memberId) {
        super(Collections.EMPTY_LIST);
        this.memberId = memberId;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return memberId;
    }
}
