package com.ddobii.back.ddobii.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginResponse {
    String userId;
    String accessToken;
}
