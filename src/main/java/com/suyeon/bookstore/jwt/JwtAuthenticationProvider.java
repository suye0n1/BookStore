package com.suyeon.bookstore.jwt;

import com.suyeon.bookstore.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtHelper jwtHelper;

    // parameter: 인증 전 객체
    // return: 인증 후 객체
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationBefore beforeToken = (JwtAuthenticationBefore) authentication;
        return jwtHelper.getAuthentication(beforeToken.getAccessToken());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationBefore.class.isAssignableFrom(authentication);
    }
}
