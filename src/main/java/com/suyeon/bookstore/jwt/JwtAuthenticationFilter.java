package com.suyeon.bookstore.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter { //권한 확인
    private JwtProvider jwtProvider;



}
