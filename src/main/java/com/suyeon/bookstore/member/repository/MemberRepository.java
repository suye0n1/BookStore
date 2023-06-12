package com.suyeon.bookstore.member.repository;

import com.suyeon.bookstore.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
