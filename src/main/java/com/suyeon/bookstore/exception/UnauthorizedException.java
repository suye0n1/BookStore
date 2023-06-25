package com.suyeon.bookstore.exception;


import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {
    public UnauthorizedException() {
        super(ErrorCode.UNAUTHROIZED.getMessage());
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
