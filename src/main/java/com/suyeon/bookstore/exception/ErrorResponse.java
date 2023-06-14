package com.suyeon.bookstore.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;

   public static ErrorResponse from(ErrorCode errorCode){
        return new ErrorResponse(errorCode.name(), errorCode.getMessage());
    }
}
