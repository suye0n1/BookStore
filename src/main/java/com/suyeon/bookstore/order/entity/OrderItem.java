package com.suyeon.bookstore.order.entity;

import com.suyeon.bookstore.item.entity.Item;
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
    @Column(name = "orderItemId")
    private Long oderItemId;

    @Column(name = "orderPrice")
    private int orderPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    private OrderItem(Long oderItemId, int orderPrice){
        this.oderItemId = oderItemId;
        this.orderPrice = orderPrice;
    }
}
