package com.dreamsecurity.lightadminback.common.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * Role
 *
 * @author smmoon
 * @since 2025-03-21
 */
@Getter
@ToString
public enum Role {
    SUPER_ADMIN("SUPER_ADMIN", "최상위 관리자")
    ,USER("USER", "일반 사용자")
    ,AUDITOR("AUDITOR", "감사 담당자");

    private final String roleName;
    private final String description;

    Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
}
