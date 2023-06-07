package com.suyeon.bookstore.member;

import com.suyeon.bookstore.cart.Cart;
import com.suyeon.bookstore.order.Orders;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Member {
    //아이디(pk), 비밀번호, 이름, 주소
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String member_id;

    @Column(length = 100, nullable = false)
    private String passwd;

    @Column(length = 30, nullable = false)
    private String m_name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "member")
    private Cart cart;

    @OneToMany(mappedBy = "member")
    private List<Orders> oderList = new ArrayList<>();
    @Builder
    public Member (Long id, String member_id,String passwd, String m_name, Address address){
        this.id = id;
        this.member_id = member_id;
        this.passwd = passwd;
        this.m_name = m_name;
        this.address = address;
    }

}
