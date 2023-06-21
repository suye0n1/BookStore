package com.suyeon.bookstore.member.service;

import com.suyeon.bookstore.jwt.JwtProvider;
import com.suyeon.bookstore.exception.LoginFailException;
import com.suyeon.bookstore.exception.UsernameDuplicationException;
import com.suyeon.bookstore.member.dto.LoginResponse;
import com.suyeon.bookstore.member.dto.JoinRequest;
import com.suyeon.bookstore.member.dto.MemberResponse;
import com.suyeon.bookstore.member.entity.Member;
import com.suyeon.bookstore.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    private JwtProvider jwtProvider;

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

    public Member join(JoinRequest joinRequest) {
        Optional<Member> username = memberRepository.findByUsername(joinRequest.getUsername());
        if(username.isPresent()){
            throw new UsernameDuplicationException();
        }

        Member member = Member.builder()
                .username(joinRequest.getUsername())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .name(joinRequest.getName())
                .address(joinRequest.getAddress())
                .build();
        return memberRepository.save(member);
    }

    public LoginResponse login(String username, String password){
        Member member = memberRepository.findByUsername(username).orElseThrow(LoginFailException::new);

            if(!passwordEncoder.matches(password, member.getPassword())){
            throw new LoginFailException();
        }

        // Access Token 생성
            String accessToken = jwtProvider.generateAccessToken(member.getUsername());

        // Refresh Token 생성
        String refreshToken = jwtProvider.generateRefreshToken(member.getUsername());

        return new LoginResponse(accessToken, refreshToken);
    }
}
