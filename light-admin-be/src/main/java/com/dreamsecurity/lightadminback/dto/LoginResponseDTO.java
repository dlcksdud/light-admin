package com.dreamsecurity.lightadminback.dto;

import lombok.*;

import java.io.Serializable;

/**
 * LoginResponseDTO
 *
 * @author smmoon
 * @since 2025-03-25
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponseDTO implements Serializable {
    private static final long serialVersionUID = 7371380860370944955L;
    private String jwtToken;
    private String refreshToken;
    private String id;
    private String name;
    private String role;
}
