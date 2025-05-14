package com.dreamsecurity.lightadminback.dto;

import com.dreamsecurity.lightadminback.common.enums.EventType;
import com.dreamsecurity.lightadminback.common.enums.ResultCode;
import com.dreamsecurity.lightadminback.util.LightAdminUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * AuditLogDTO
 *
 * @author smmoon
 * @since 2025-04-08
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogDTO {
    private String creator;
    private LocalDateTime createDate;
    private String code;

    private String resultMessage;

    private String requestData;
    private String responseData;

    private String eventType;
    private String page;

    public static AuditLogDTO of(ResultCode resultCode, EventType eventType, String page,
                                 String requestData, String responseData) {
        return new AuditLogDTO(
                LightAdminUtil.getCurrentUsername(),
                LightAdminUtil.now(),
                resultCode.getCode(),
                resultCode.getMessage(),
                requestData,
                responseData,
                eventType.getType(),
                page
        );
    }

}
