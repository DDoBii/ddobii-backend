package com.ddobii.back.ddobii.user.dto.request;

import com.ddobii.back.ddobii.global.error.enums.RegexConstants;
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

    @NotBlank(message = "아이디 항목이 누락되지 않았는지 확인해주세요!")
    String userId;

    @NotBlank(message = "비밀번호 항목이 누락되지 않았는지 확인해주세요!")
    @Pattern(regexp = RegexConstants.PASSWORD_REGEX, message = "비밀번호를 다시 입력해주세요. 4~16자의 영문, 대소문자, 숫자, 특수문자를 자유롭게 조합하여 설정해주세요!")
    String password;

    @NotBlank(message = "이름 항목이 누락되지 않았는지 확인해주세요!")
    String name;

    @NotBlank(message = "엠비티아이 항목이 누락되지 않았는지 확인해주세요!")
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
