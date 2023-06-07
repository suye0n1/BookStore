package com.suyeon.bookstore.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member join(MemberDto memberDto){
        Member member = Member.builder()
                .member_id(memberDto.getMember_id())
                .passwd(memberDto.getPasswd())
                .m_name(memberDto.getM_name())
                .address(memberDto.getAddress())
                .build();
     return memberRepository.save(member);
    }
}
