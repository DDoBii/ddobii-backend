package com.ddobii.back.ddobii.global.error.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ddobii.back.ddobii.global.error.enums.ErrorCode;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

    private final int status;

    private final HttpStatus error;

    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.error = errorCode.getError();
        this.message = errorCode.getMessage();
    }

    public static ResponseEntity<ErrorResponse> error(DdobiiException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorResponse.builder()
                        .status(e.getErrorCode().getStatus())
                        .error(e.getErrorCode().getError())
                        .message(e.getErrorCode().getMessage())
                        .build());
    }

}
