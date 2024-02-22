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

    private String secretKey;

    public JwtTokenProvider() {
        // 직접 값 할당 - UUID를 사용하여 랜덤한 문자열 생성
        this.secretKey = UUID.randomUUID().toString();
    }

    /**
     * 액세스 토큰과 리프레시 토큰을 생성하는 메서드입니다.
     *
     * @param userId 사용자 ID
     * @return 생성된 액세스 토큰과 리프레시 토큰을 담은 객체
     */
    public TokenPair generateTokens(String userId) {
        Date now = new Date();
        // 액세스 토큰 생성
        String accessToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("fresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
                .claim("id", userId)
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();

        // 리프레시 토큰 생성
        String refreshToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("fresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofDays(7).toMillis())) // 예시로 7일 설정
                .claim("id", userId)
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();

        return new TokenPair(accessToken, refreshToken);
    }

    /**
     * JWT 토큰을 파싱하여 클레임(데이터)을 추출하는 메서드입니다.
     *
     * @param token 검증할 JWT 토큰
     * @return 토큰의 클레임(데이터)
     */
    @SuppressWarnings("deprecation")
    public Claims parseJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }
}
