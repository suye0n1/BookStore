package com.suyeon.bookstore.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
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
    private List<Item> itemList = new ArrayList<>();


}
