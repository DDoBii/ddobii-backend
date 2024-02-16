package com.ddobii.back.ddobii.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginResponse {

    String userId; // 아이디

    String password; // 비밀번호

}
