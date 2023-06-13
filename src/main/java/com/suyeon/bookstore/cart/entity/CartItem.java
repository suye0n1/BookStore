package com.suyeon.bookstore.cart.entity;

import com.suyeon.bookstore.item.entity.Item;
import com.suyeon.bookstore.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CartItem {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "count")
    private int count;  //상품 개수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    private CartItem (Long cartId, int count){
        this.cartId = cartId;
        this.count = count;
    }
}
