package com.dreamsecurity.lightadminback.common.exception;

import com.dreamsecurity.lightadminback.common.enums.ErrorCode;
import lombok.Getter;
import lombok.ToString;

/**
 * ErrorCode
 *
 * @author smmoon
 * @since 2025-04-04
 */
@Getter
@ToString
public class BaseException extends RuntimeException{
    private final ErrorCode errorCode;

    public BaseException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

}
