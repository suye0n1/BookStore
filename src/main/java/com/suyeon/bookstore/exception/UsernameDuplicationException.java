package com.suyeon.bookstore.exception;

import lombok.Getter;

@Getter
public class UsernameDuplicationException extends RuntimeException{

    private final ErrorCode errorCode;

    public UsernameDuplicationException(){
        this(ErrorCode.USER_DUPLICATION, ErrorCode.USER_DUPLICATION.getMessage());
    }

    public UsernameDuplicationException(ErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

}