package com.suyeon.bookstore.config;

import com.suyeon.bookstore.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity  //모든 요청 URL이 Spring Security의 제어를 받음
public class SecurityConfig{

    private JwtProvider jwtProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {   //인증되지 않은 요청 허락

        return http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()//.authorizeRequestsr가  .authorizeHttpRequests로
                .requestMatchers("/auth/**").permitAll()//.antMatchers()가 .requestMatchers로
                .and()
                .getOrBuild();
    }

    @Bean
    PasswordEncoder passwordEncoder(){  //암호화 Bean으로 등록
        return new BCryptPasswordEncoder();
    }


}
