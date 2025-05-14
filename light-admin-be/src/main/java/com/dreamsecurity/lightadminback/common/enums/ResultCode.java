package com.dreamsecurity.lightadminback.common.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * ResultCode
 *
 * @author smmoon
 * @since 2025-04-04
 */
@Getter
@ToString
public enum ResultCode {

    SUCCESS("1000", "Success"),
    FAILED("2000", "Failed");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
