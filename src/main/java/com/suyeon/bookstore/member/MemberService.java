package com.suyeon.bookstore.member;

import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member createJoin(MemberDto memberDto){
        Member member = Member.builder()
                .member_id(memberDto.getMember_id())
                .passwd(passwordEncoder.encode(memberDto.getPasswd()))
                .m_name(memberDto.getM_name())
                .address(memberDto.getAddress())
                .build();
     return memberRepository.save(member);
    }

}
