package com.suyeon.bookstore.item.repository;

import com.suyeon.bookstore.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
