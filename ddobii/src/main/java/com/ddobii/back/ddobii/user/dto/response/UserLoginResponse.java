package com.ddobii.back.ddobii.user.dto.response;

import com.ddobii.back.ddobii.global.jwt.TokenPair;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginResponse {

    private String userId;

    private TokenPair tokenPair; // TokenPair를 사용할 수 있도록 추가
}
