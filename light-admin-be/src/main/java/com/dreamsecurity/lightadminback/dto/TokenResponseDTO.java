package com.dreamsecurity.lightadminback.dto;

import lombok.Builder;
import lombok.Data;

/**
 * TokenResponseDTO
 *
 * @author smmoon
 * @since 2025-03-28
 */
@Data
@Builder
public class TokenResponseDTO {
    private String accessToken;
    private String refreshToken;
}
