package com.suyeon.bookstore.cart;

import com.suyeon.bookstore.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    private int count; //카트에 담긴 상품의 총 개수

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //member_id(fk)
    private Member member;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList = new ArrayList<>();

}
