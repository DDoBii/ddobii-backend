package com.ddobii.back.ddobii.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddobii.back.ddobii.global.error.exception.DdobiiException;
import com.ddobii.back.ddobii.global.error.exception.ErrorResponse;
import com.ddobii.back.ddobii.user.dto.request.UserLoginRequest;
import com.ddobii.back.ddobii.user.dto.request.UserSignupRequest;
import com.ddobii.back.ddobii.user.dto.response.UserLoginResponse;
import com.ddobii.back.ddobii.user.dto.response.UserSignupResponse;
import com.ddobii.back.ddobii.user.model.User;
import com.ddobii.back.ddobii.user.service.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "사용자 컨트롤러", description = "사용자 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ddobii")
public class UserController {

    private final UserServiceImpl userService;

    @Operation(summary = "회원가입", description = "회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ResponseEntity<UserSignupResponse> signup(@Valid @RequestBody UserSignupRequest request) {

        UserSignupResponse response = userService.signup(request);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "로그인", description = "사용자 로그인을 수행합니다.")
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest request) {

        UserLoginResponse response = userService.login(request);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "특정 회원 조회", description = "특정 회원의 정보를 조회합니다.")
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {

        Optional<User> userOptional = userService.getUserById(userId);

        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "모든 회원 조회", description = "모든 회원의 정보를 조회합니다.")
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

    @Operation(summary = "특정 예외 처리", description = "DDOBII 예외를 처리합니다.")
    @ExceptionHandler(DdobiiException.class)
    public ResponseEntity<ErrorResponse> handleSupportException(DdobiiException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
