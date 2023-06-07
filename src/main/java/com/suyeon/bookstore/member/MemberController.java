package com.suyeon.bookstore.member;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;
import java.util.List;

@RestController
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/auth/join")
    public Member join(@RequestBody MemberDto memberDto){
        return memberService.join(memberDto);
    }


}
