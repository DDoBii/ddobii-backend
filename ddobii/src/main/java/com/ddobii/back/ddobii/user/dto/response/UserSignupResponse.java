package com.ddobii.back.ddobii.user.dto.response;

import com.ddobii.back.ddobii.user.model.User;

import lombok.Getter;

@Getter
public class UserSignupResponse {

    String userId; // 아이디

    String name; // 이름

    String mbti; // 엠비티아이

    public UserSignupResponse(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.mbti = user.getMbti();
    }
}
