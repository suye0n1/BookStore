package com.suyeon.bookstore.member.controller;


import com.suyeon.bookstore.member.dto.*;
import com.suyeon.bookstore.member.entity.Member;
import com.suyeon.bookstore.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/api/members")
    public List<MemberResponse> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping("/auth/join")
    public Member join(@Valid @RequestBody JoinRequest joinRequest){
        return memberService.join(joinRequest);

    }

    @PostMapping("/auth/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest){
      String username = loginRequest.getUsername();
      String password = loginRequest.getPassword();
      return memberService.login(username,password);

    }


}
