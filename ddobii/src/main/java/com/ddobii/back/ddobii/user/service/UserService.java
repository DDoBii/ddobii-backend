package com.ddobii.back.ddobii.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddobii.back.ddobii.user.dto.request.UserSignupRequest;
import com.ddobii.back.ddobii.user.dto.response.UserSignupResponse;
import com.ddobii.back.ddobii.user.model.User;
import com.ddobii.back.ddobii.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;

    /*
     * 회원가입 API
     */
    @Transactional
    public UserSignupResponse signup(UserSignupRequest request) {
        // 아이디 중복 검사
        Optional<User> existingUser = userRepository.findByUserId(request.getUserId());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("중복되는 아이디 입니다.");
        }

        User user = request.toEntity();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        logger.info("사용자 객체 생성: {}", user);
        
        User savedUser = userRepository.save(user);
        logger.info("사용자 저장 완료: {}", savedUser);
        
        // UserSignupResponse 객체로 변환하여 반환
        return new UserSignupResponse(savedUser);
    }

    /*
     * 특정 회원 조회 API
     */
    public Optional<User> getUserById(String userId) {
        return userRepository.findByUserId(userId);
    }

    /*
     * 모든 회원 조회 API
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
