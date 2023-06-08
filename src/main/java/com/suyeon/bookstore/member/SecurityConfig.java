package com.suyeon.bookstore.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity  //모든 요청 URL이 Spring Security의 제어를 받음
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {   //인증되지 않은 요청 허락
        http.authorizeHttpRequests().requestMatchers(
                        new AntPathRequestMatcher("/**")).permitAll()   //csrf 때문에 오류 발생
                .and()  //403에러 처리
                .csrf().disable();

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){  //암호화 Bean으로 등록
        return new BCryptPasswordEncoder();
    }


}
