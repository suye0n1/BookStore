package com.suyeon.bookstore.order.repository;

import com.suyeon.bookstore.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<Order, Long> {
}
