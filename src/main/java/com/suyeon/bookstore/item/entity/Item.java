package com.suyeon.bookstore.item.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "itemId")
    private Long itemId;

    @Column(name = "itemDetail")
    private String itemDetail;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "price")
    private int price;

    @Builder
    private Item (Long itemId, String itemDetail, String itemName, int price){
        this.itemId = itemId;
        this.itemDetail = itemDetail;
        this.itemName = itemName;
        this.price = price;
    }


}
