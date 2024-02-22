package com.ddobii.back.ddobii.global.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenPair {

    private final String accessToken; // 액세스 토큰

    private final String refreshToken; // 리프레시 토큰

}