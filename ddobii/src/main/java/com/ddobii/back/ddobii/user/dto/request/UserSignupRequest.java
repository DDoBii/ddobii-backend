package com.ddobii.back.ddobii.user.dto.request;

import com.ddobii.back.ddobii.user.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserSignupRequest {

    String userId;

    @NotBlank(message = "패스워드가 정확하지 않습니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_,.?~]).{8,15}$")
    String password;

    String name;

    String mbti;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .password(password)
                .name(name)
                .mbti(mbti)
                .build();
    }
}
