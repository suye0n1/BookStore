package com.suyeon.bookstore.member;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
@RestController
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/api/members")
    public List<Member> getAllBoards(){
        return memberService.getAllMembers();
    }

   /* @GetMapping("/auth/join")
    public String JoinForm(){
        return "members/joinForm";
    }*/
    @PostMapping("/auth/join")
    public Member join(@Valid @RequestBody MemberDto memberDto){
        return memberService.createJoin(memberDto);

    }


}
