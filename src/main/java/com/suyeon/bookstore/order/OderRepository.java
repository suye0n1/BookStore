package com.suyeon.bookstore.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<Orders, Long> {
}
