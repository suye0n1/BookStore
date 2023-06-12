package com.suyeon.bookstore.member.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Column(length = 1024, nullable = false)
    private String address;  //주소
    private String addressDetail; //상세 주소
    private String zipCode; //우편번호
}
