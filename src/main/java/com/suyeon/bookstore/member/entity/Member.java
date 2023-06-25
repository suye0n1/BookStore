package com.suyeon.bookstore.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Member {
    //아이디(pk), 비밀번호, 이름, 주소
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Embedded
    @Column(name = "address", nullable = false)
    private Address address;

    @Builder
    public Member (Long id, String username,String password, String name, Address address){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;

    }
}
