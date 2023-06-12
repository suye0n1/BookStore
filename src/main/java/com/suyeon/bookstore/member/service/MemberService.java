package com.suyeon.bookstore.member.service;

import com.suyeon.bookstore.member.dto.MemberResponse;
import com.suyeon.bookstore.member.dto.JoinDto;
import com.suyeon.bookstore.member.entity.Member;
import com.suyeon.bookstore.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    public List<MemberResponse> getAllMembers(){
        return memberRepository.findAll()
                .stream()
                .map(member -> {
                    MemberResponse response = new MemberResponse();
                    response.setId(member.getId());
                    response.setName(member.getName());
                    response.setUsername(member.getUsername());
                    return response;
                }).toList();
    }

    public Member createJoin(JoinDto memberDto){
        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .address(memberDto.getAddress())
                .build();
     return memberRepository.save(member);
    }

}
