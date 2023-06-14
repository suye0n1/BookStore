package com.suyeon.bookstore.order.entity;

import com.suyeon.bookstore.common.BaseTimeEntity;
import com.suyeon.bookstore.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Order(Long orderId){
        this.orderId = orderId;
    }
}
