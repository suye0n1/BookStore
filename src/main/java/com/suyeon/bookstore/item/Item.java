package com.suyeon.bookstore.item;

import com.suyeon.bookstore.cart.CartItem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long item_id;

    private String item_detail;

    private String item_name;

    private int price;

    @OneToMany(mappedBy = "item")
    private List<CartItem> cartItemList = new ArrayList<>();

    @Builder
    private Item (Long item_id, String item_detail, String item_name, int price){
        this.item_id = item_id;
        this.item_detail = item_detail;
        this.item_name = item_name;
        this.price = price;
    }


}
