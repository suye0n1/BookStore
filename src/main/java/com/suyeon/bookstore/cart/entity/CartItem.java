package com.suyeon.bookstore.cart.entity;


import com.suyeon.bookstore.item.entity.Item;
import com.suyeon.bookstore.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}
