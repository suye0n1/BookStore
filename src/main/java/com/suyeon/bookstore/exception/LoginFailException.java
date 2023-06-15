package com.suyeon.bookstore.exception;

import lombok.Getter;

@Getter
public class LoginFailException extends RuntimeException{
    private final ErrorCode errorCode;

    public LoginFailException(){
        this(ErrorCode.LOGIN_FAIL, ErrorCode.LOGIN_FAIL.getMessage());
    }

    public LoginFailException(ErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
