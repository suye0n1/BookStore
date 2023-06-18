package com.suyeon.bookstore.member.controller;


import com.suyeon.bookstore.member.dto.JoinDto;
import com.suyeon.bookstore.member.dto.LoginDto;
import com.suyeon.bookstore.member.entity.Member;
import com.suyeon.bookstore.member.dto.MemberResponse;
import com.suyeon.bookstore.member.repository.MemberRepository;
import com.suyeon.bookstore.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.h2.command.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/api/members")
    public List<MemberResponse> getAllBoards(){
        return memberService.getAllMembers();
    }

    @PostMapping("/auth/join")
    public Member join(@Valid @RequestBody JoinDto memberDto){
        return memberService.createJoin(memberDto);

    }

    @PostMapping("/auth/login")
    public String login(@Valid @RequestBody LoginDto loginDto){
      String username = loginDto.getUsername();
      String password = loginDto.getPassword();
      return memberService.login(username,password);

    }


}
