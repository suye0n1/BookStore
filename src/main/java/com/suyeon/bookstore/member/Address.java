package com.suyeon.bookstore.member;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Column(length = 1024, nullable = false)
    private String adr;  //주소
    private String adr_detail; //상세 주소
    private String zipCode; //우편번호
}
