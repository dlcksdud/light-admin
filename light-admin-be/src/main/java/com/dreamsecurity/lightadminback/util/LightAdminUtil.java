package com.dreamsecurity.lightadminback.util;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LightAdminUtil {

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 현재 인증된 사용자 이름을 반환
     * 인증되지 않은 경우 "anonymous" 반환
     */
    public static String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return "anonymous";
    }


}
