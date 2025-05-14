package com.dreamsecurity.lightadminback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserDTO
 *
 * @author smmoon
 * @since 2025-03-21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int seq;
    private String id;
    private String password;
    private String state;
    private String name;
    private String email;
    private String phone;
    private String roles;
    private String creator;
    private String modifier;
    private String createDate;
    private String modifyDate;
    private String lastAccessDate;
}
