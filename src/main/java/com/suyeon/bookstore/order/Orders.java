package com.suyeon.bookstore.order;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Orders extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long order_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Orders orders;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> itemList = new ArrayList<>();
}
