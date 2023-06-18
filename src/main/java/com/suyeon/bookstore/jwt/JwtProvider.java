package com.suyeon.bookstore.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;


@RequiredArgsConstructor
@Component
public class JwtProvider {

    private String secretKey;
    private final long accessTokenValidTime = (60 * 1000) * 30; // 30분
    private final long refreshTokenValidTime = (60 * 1000) * 60 * 24 * 7; // 7일
    private final RefreshTokenRepository refreshTokenRepository;
    private final String AUTHORITIES_KEY = "auth";

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(SecretKey.JWT_SECRET_KEY.getBytes());
    }

    // 토큰 생성
    public String generateToken(Authentication authentication, Long accessTokenValidTime) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        Date now = new Date();
        Date expiration = new Date(now.getTime() + accessTokenValidTime);
        return Jwts.builder()
                .setHeaderParam("type","jwt") //type이 jwt임을 설정
                .claim(AUTHORITIES_KEY, authorities) //payload에 담길 데이터 입력
                .setIssuedAt(now) //발급시간(현재시간)
                .setExpiration(expiration) //만료 시간
                .signWith(SignatureAlgorithm.HS256, SecretKey.JWT_SECRET_KEY) //서명 알고리즘 = HS256(비밀키 별도 클래스에서 관리)
                .compact(); //JWT 토큰 생성
    }

    public String generateAccessToken(Authentication authentication){
        return generateToken(authentication, accessTokenValidTime);
    }

    public String generateRefreshToken(Authentication authentication){
        return generateToken(authentication, refreshTokenValidTime);
    }


}
