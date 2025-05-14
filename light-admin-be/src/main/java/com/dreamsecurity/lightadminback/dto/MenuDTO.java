package com.dreamsecurity.lightadminback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * MenuDTO
 *
 * @author smmoon
 * @since 2025-04-17
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Integer seq;
    private Integer number;
    private String name;
    private Integer level;
    private Integer parentSeq;
    private String text;
    private String icon;
    private String exposure;
    private String path;
    private String creator;
    private String modifier;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
