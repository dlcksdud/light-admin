package com.dreamsecurity.lightadminback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * JwtRequestDTO
 *
 * @author smmoon
 * @since 2025-03-24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestDTO {
    @NotBlank(message = "Username cannot be blank")
    private String id;
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
