package com.suyeon.bookstore.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtProvider {

  //  private String secretKey;

    private Key key;
    private long accessTokenValidTime = (60 * 1000) * 30; // 30분
    private long refreshTokenValidTime = (60 * 1000) * 60 * 24 * 7; // 7일

    private final String AUTHORITIES_KEY = "auth";

    @PostConstruct
    protected void init(){
        byte[] apiKeySecretBytes = Decoders.BASE64.decode(SecretKey.JWT_SECRET_KEY);
        key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    // 토큰 생성
    public String generateToken(String username, Long tokenValidTime) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + tokenValidTime);
        return Jwts.builder()
                .setHeaderParam("type","jwt") //type이 jwt임을 설정
                .claim("username", username) //payload에 담길 데이터 입력
                .setIssuedAt(now) //발급시간(현재시간)
                .setExpiration(expiration) //만료 시간
                .signWith(key,SignatureAlgorithm.HS256) //서명 알고리즘 = HS256(비밀키 별도 클래스에서 관리)
                .compact(); //JWT 토큰 생성
    }

    public String generateAccessToken(String username){
        return generateToken(username, accessTokenValidTime);
    }

    public String generateRefreshToken(String username){
        return generateToken(username, refreshTokenValidTime);
    }

    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        String username = claims.getSubject();
        User principal = new User(username, "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);

    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

}
