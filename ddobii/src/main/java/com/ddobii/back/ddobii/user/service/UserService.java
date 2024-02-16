package com.ddobii.back.ddobii.user.service;
import java.util.List;
import java.util.Optional;

import com.ddobii.back.ddobii.user.dto.request.UserSignupRequest;
import com.ddobii.back.ddobii.user.dto.response.UserSignupResponse;
import com.ddobii.back.ddobii.user.model.User;

public interface UserService {
    
    // 회원가입 API
    public UserSignupResponse signup(UserSignupRequest request);

    // 특정 회원 조회 API
    public Optional<User> getUserById(String userId);

    // 모든 회원 조회 API
    public List<User> getAllUsers();
}
