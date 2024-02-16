package com.ddobii.back.ddobii.user.dto.response;

import com.ddobii.back.ddobii.user.model.User;

import lombok.Getter;

@Getter
public class UserSignupResponse {

    String userId;

    String name;

    String mbti;

    public UserSignupResponse(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.mbti = user.getMbti();
    }
}
