package com.suyeon.bookstore.order;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long orderItem_id;

    private int order_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Builder
    private OrderItem(Long orderItem_id, int order_price){
        this.orderItem_id = orderItem_id;
        this.order_price = order_price;
    }
}
