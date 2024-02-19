package com.ddobii.back.ddobii.global.error.exception;

import com.ddobii.back.ddobii.global.error.enums.ErrorCode;

// import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
// @AllArgsConstructor
public class DdobiiException extends RuntimeException {
    private final ErrorCode errorCode;

    public DdobiiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }

}