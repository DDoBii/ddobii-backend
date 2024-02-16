package com.ddobii.back.ddobii.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddobii.back.ddobii.user.dto.request.UserLoginRequest;
import com.ddobii.back.ddobii.user.dto.request.UserSignupRequest;
import com.ddobii.back.ddobii.user.dto.response.UserLoginResponse;
import com.ddobii.back.ddobii.user.dto.response.UserSignupResponse;
import com.ddobii.back.ddobii.user.model.User;
import com.ddobii.back.ddobii.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /*
     * 회원가입 API
     */
    @Override
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
     * 로그인 API
     */
    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        String userId = userLoginRequest.getUserId();
        String password = userLoginRequest.getPassword();

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userId));

        // 비밀번호 검증
        boolean passwordMatch = passwordEncoder.matches(password, user.getPassword());
        if (!passwordMatch) {
            throw new BadCredentialsException("비밀번호가 올바르지 않습니다.: " + userId);
        }

        // UserLoginResponse 생성 및 반환
        UserLoginResponse userLoginResponse = new UserLoginResponse(userId, password);

        return userLoginResponse;
    }

    /*
     * 특정 회원 조회 API
     */
    @Override
    public Optional<User> getUserById(String userId) {
        return userRepository.findByUserId(userId);
    }

    /*
     * 모든 회원 조회 API
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
