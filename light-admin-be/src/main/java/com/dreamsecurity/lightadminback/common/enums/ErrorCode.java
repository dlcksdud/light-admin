package com.dreamsecurity.lightadminback.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * ErrorCode
 *
 * @author smmoon
 * @since 2025-04-04
 */
@Getter
@ToString
public enum ErrorCode {
    // 공통
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "2000", "Invalid request."),
    ACCESS_DENIED_EXCEPTION(HttpStatus.FORBIDDEN, "2001", "Access denied."), // Spring Security에서 주로 사용
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "2002", "Internal server error."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "2003", "Resource not found."),
    PAGING_ERROR(HttpStatus.BAD_REQUEST, "2004", "Invalid paging request."),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "2005", "Invalid ID or password"),
    UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, "2007", "Unathorized."),
    INVALID_REFRESH_TOKEN(HttpStatus.FORBIDDEN, "2008", "Invalid Refresh Token"),
    EXPIRED_REFRESH_TOKEN(HttpStatus.FORBIDDEN, "2009", "Expired Refresh Token."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "2010", "Forbidden request."), // 비즈니스 정책상 접근 금지 (예: 관리자만 접근 가능)
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "2011", "User Not Found."),
    MISSING_PARAMETER(HttpStatus.BAD_REQUEST, "2012", "Missing required request parameter."),



    // ───────────────────────────────
    // 📝 감사로그 (Audit Log)
    // ───────────────────────────────
    AUDIT_LOGGING_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "2020", "Audit logging failed."),

    // ───────────────────────────────
    // 🗄️ 데이터베이스(DB)
    // ───────────────────────────────
    DATABASE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "5006", "Database record not found."),
    DATABASE_SAVE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5007", "Failed to save data."),
    DATABASE_DELETE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5008", "Failed to delete data."),
    DATABASE_UPDATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5009", "Failed to update data.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
