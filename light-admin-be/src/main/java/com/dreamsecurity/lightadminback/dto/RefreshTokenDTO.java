package com.dreamsecurity.lightadminback.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * RefreshTokenDTO
 *
 * @author smmoon
 * @since 2025-03-28
 */
@Data
public class RefreshTokenDTO {
    private String userId;
    private String token;
    private Date expiryDate;
}
