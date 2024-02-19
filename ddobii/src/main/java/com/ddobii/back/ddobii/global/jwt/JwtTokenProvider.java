package com.ddobii.back.ddobii.global.jwt;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    // @Value("${security.jwt.secret}")
    // private String secretKey;

    private String secretKey;

    public JwtTokenProvider() {
        // 직접 값 할당 - UUID를 사용하여 랜덤한 문자열 생성
        this.secretKey = UUID.randomUUID().toString();
    }

    /**
     * JWT 토큰을 생성하는 메서드입니다.
     *
     * @param userId 사용자 ID
     * @return 생성된 JWT 토큰
     */
    public String generateToken(String userId) {
        Date now = new Date();
        // JWT 토큰을 생성하는 빌더를 시작
        return Jwts.builder()
                // JWT 헤더에 유형을 설정 (Type)
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                // JWT 토큰의 발급자 설정 (Issuer)
                .setIssuer("fresh")
                // 토큰 발급 시간 설정 (Issued At)
                .setIssuedAt(now)
                // 토큰 만료 시간 설정 (현재 시간으로부터 30분 후)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
                // JWT 클레임에 사용자 ID 추가
                .claim("id", userId)
                // JWT 토큰을 시크릿 키로 서명하고 알고리즘은 HS256을 사용
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                // 최종적인 JWT 문자열 반환
                .compact();
    }

    /**
     * JWT 토큰을 파싱하여 클레임(데이터)을 추출하는 메서드입니다.
     *
     * @param token 검증할 JWT 토큰
     * @return 토큰의 클레임(데이터)
     */
    @SuppressWarnings("deprecation")
    public Claims parseJwtToken(String token) {
        // JWT 토큰을 파싱하여 클레임(데이터)을 추출하는 메서드
        return Jwts.parser()
                // 시크릿 키를 이용하여 토큰을 검증하고 파싱
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                // 전달된 JWT 토큰을 파싱하고 서명 검증
                .parseClaimsJws(token)
                // 토큰의 클레임(데이터)을 반환
                .getBody();
    }

}
