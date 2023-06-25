package com.suyeon.bookstore.member.controller;


import com.suyeon.bookstore.jwt.JwtAuthenticationAfter;
import com.suyeon.bookstore.member.dto.*;
import com.suyeon.bookstore.member.entity.Member;
import com.suyeon.bookstore.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/api/members")
    public List<MemberResponse> getAllMembers(@AuthenticationPrincipal Long memberId) { // 방법 1
        // 방법 2
//        JwtAuthenticationAfter token = (JwtAuthenticationAfter) SecurityContextHolder.getContext().getAuthentication();
//        Long memberId = token.getMemberId();
        System.out.println("memberId: " + memberId);
        return memberService.getAllMembers();
    }

    @PostMapping("/auth/join")
    public Member join(@Valid @RequestBody JoinRequest joinRequest){
        return memberService.join(joinRequest);
    }

    @PostMapping("/auth/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response){
      String username = loginRequest.getUsername();
      String password = loginRequest.getPassword();
      return memberService.login(username,password, response);
    }

    @GetMapping("/auth/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        // Redis 로 블랙리스트 토큰 구현하면 로그아웃 구현 가능
    }

}
