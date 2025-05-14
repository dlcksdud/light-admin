package com.dreamsecurity.lightadminback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * RoleMenuMapDTO
 *
 * @author smmoon
 * @since 2025-04-17
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenuMapDTO {
    private Integer menuSeq;
    private Integer roleSeq;
    private String creator;
    private LocalDateTime createDate;
}
