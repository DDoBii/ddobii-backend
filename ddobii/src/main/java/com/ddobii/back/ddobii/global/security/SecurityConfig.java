package com.ddobii.back.ddobii.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 암호화
    }

    /**
     * 보안 필터 체인 구성
     */
    @Bean
    @SuppressWarnings({ "deprecation", "removal" })
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // 인가 설정
                .requestMatchers("/ddobii/**").permitAll() // 요청 매처 설정 및 인증 없이 허용
                .requestMatchers("/ddobii/login").permitAll()
                .anyRequest().authenticated() // 모든 요청에 대한 설정 및 인증이 필요한 요청 설정
                .and()
                .csrf().disable(); // CSRF 기능 비활성화

        return http.build(); // 보안 필터 체인 빌드
    }

}
