package com.ddobii.back.ddobii.global.error.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /* 200 OK */
    SUCCESS(200, HttpStatus.OK, "OK"),

    /* 400 */
    USER_ID_DUPLICATION(409, HttpStatus.CONFLICT, "이미 사용 중인 아이디입니다. 정보를 다시 입력해주세요."),
    USER_NOT_FOUND(404, HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.  정보를 다시 입력해주세요."),
    PASSWORD_NOT_FOUND(401, HttpStatus.UNAUTHORIZED, "비밀번호가 올바르지 않습니다.  정보를 다시 입력해주세요."),
    INVALID_REQUEST_FORMAT(400, HttpStatus.BAD_REQUEST, "요청 형식이 올바르지 않습니다."),

    /* 500 */
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버에서 예기치 못한 오류가 발생했습니다.");

    /* field */
    private final int status;
    private final HttpStatus error;
    private final String message;

}