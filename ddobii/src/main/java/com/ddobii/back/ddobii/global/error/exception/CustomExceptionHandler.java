package com.ddobii.back.ddobii.global.error.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ddobii.back.ddobii.global.error.enums.ErrorCode;

@ControllerAdvice
public class CustomExceptionHandler {
    
/*
     * 유효성 검증 예외 처리 설명:
     *
     * - ex.getBindingResult(): MethodArgumentNotValidException에서 발생한 유효성 결과를 반환
     * - .getFieldError(): BindingResult에서 첫 번째 유효성 검사 오류를 반환
     * - .getDefaultMessage(): FieldError에서 유효성 검사 오류의 기본 메시지를 반환
     */

    /*
     * 유효성 검증에 대한 예외처리를 수행합니다.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        ErrorCode errorCode = ErrorCode.INVALID_REQUEST_FORMAT; // Default
        int status = errorCode.getStatus();

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status)
                .error(errorCode.getError())
                .message(ex.getBindingResult().getFieldError().getDefaultMessage())
                .build();

        return ResponseEntity.status(status).body(errorResponse);
    }

    /*
     * 500 에러에 대한 예외처리를 수행합니다.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        int status = errorCode.getStatus();

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status)
                .error(errorCode.getError())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.status(status).body(errorResponse);
    }
}