package com.suyeon.bookstore.jwt;

import com.suyeon.bookstore.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<Member, Long> {
}
