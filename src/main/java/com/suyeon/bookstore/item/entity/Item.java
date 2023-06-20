package com.suyeon.bookstore.item.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_detail")
    private String itemDetail;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private int price;

}
