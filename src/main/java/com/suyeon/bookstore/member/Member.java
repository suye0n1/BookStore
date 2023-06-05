package com.suyeon.bookstore.member;

import com.suyeon.bookstore.cart.Cart;
import com.suyeon.bookstore.order.Orders;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {
    //아이디(pk), 비밀번호, 이름, 주소
    @Id
    @GeneratedValue
    private Long member_id;

    @Column(length = 100, nullable = false)
    private String passwd;

    @Column(length = 30, nullable = false)
    private String m_name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "member_id")
    private Cart cart;

    @OneToMany(mappedBy = "member")
    private List<Orders> oderList = new ArrayList<>();


}
