
package com.suyeon.bookstore.exception;

public enum ErrorCode {

    //아이디
    INTERNAL_SERVER_ERROR("예상하지 못한 에러가 발생 했습니다."),
    USER_DUPLICATION("중복된 아이디 입니다."),
    FORBIDDEN("해당 API 를 호출할 수 없는 사용자입니다."),
    LOGIN_FAIL("아이디 혹은 패스워드를 잘못 입력하셨습니다."),
    UNAUTHROIZED("인증 정보가 유효하지 않습니다.");


    private String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}







