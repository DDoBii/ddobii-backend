package com.ddobii.back.ddobii.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddobii.back.ddobii.user.dto.request.UserLoginRequest;
import com.ddobii.back.ddobii.user.dto.request.UserSignupRequest;
import com.ddobii.back.ddobii.user.dto.response.UserLoginResponse;
import com.ddobii.back.ddobii.user.dto.response.UserSignupResponse;
import com.ddobii.back.ddobii.user.model.User;
import com.ddobii.back.ddobii.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ddobii")
public class UserController {

    private final UserServiceImpl userService;

    /*
     * 회원가입 API
     */
    @PostMapping("/signup")
    public ResponseEntity<UserSignupResponse> signup(@RequestBody UserSignupRequest request) {

        UserSignupResponse response = userService.signup(request);

        return ResponseEntity.ok(response);
    }

    /*
     * 로그인 API
     */
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {

        UserLoginResponse response = userService.login(request);

        return ResponseEntity.ok(response);
    }

    /*
     * 특정 회원 조회 API
     */
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {

        Optional<User> userOptional = userService.getUserById(userId);

        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * 모든 회원 조회 API
     */
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        
        List<User> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

}
