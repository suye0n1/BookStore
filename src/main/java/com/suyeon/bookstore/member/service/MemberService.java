package com.suyeon.bookstore.member.service;

import com.suyeon.bookstore.jwt.JwtHelper;
import com.suyeon.bookstore.exception.LoginFailException;
import com.suyeon.bookstore.exception.UsernameDuplicationException;
import com.suyeon.bookstore.member.dto.LoginResponse;
import com.suyeon.bookstore.member.dto.JoinRequest;
import com.suyeon.bookstore.member.dto.MemberResponse;
import com.suyeon.bookstore.member.entity.Member;
import com.suyeon.bookstore.member.repository.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService{

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    private JwtHelper jwtHelper;
    private AuthenticationManagerBuilder authenticationManagerBuilder;

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

    public LoginResponse login(String username, String password, HttpServletResponse response){
        Member member = memberRepository.findByUsername(username).orElseThrow(LoginFailException::new);

        if(!passwordEncoder.matches(password, member.getPassword())){
            throw new LoginFailException();
        }

       // Access Token 생성
        String accessToken = jwtHelper.generateAccessToken(member.getId());

        // Refresh Token 생성
        String refreshToken = jwtHelper.generateRefreshToken(member.getId());

        // 리프레시토큰 쿠키에 담기
        // 옵셔널한 부분
        Cookie cookie = new Cookie("refreshToken", refreshToken); //쿠키 생성
        cookie.setMaxAge(1000*60*60*24*7); //쿠키 유지 기간
        cookie.setHttpOnly(true); //javascript코드 접근 불가능
        member.setUsername(username);
        response.addCookie(cookie);

        return new LoginResponse(accessToken, refreshToken);
    }

}
