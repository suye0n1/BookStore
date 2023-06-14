package com.suyeon.bookstore.cart.repository;

import com.suyeon.bookstore.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    /*@Query("select ci from CartItem ci where ci.cart = '' ")
     CartItem getCartItemByCart();*/
}
