package com.ddobii.back.ddobii.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginRequest {

    String userId; // 아이디

    @NotBlank(message = "비밀번호는 최소 8자 이상, 최대 15자 이하로 설정되어야 합니다.\n" + //
            "최소한 하나의 소문자, 대문자, 숫자, 특수문자(!@#$%^&*_,.?~)를 포함해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_,.?~]).{8,15}$")
    String password; // 비밀번호
}
