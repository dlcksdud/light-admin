package com.dreamsecurity.lightadminback.dto;

import com.dreamsecurity.lightadminback.common.enums.ErrorCode;
import com.dreamsecurity.lightadminback.common.enums.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * ResponseDTO
 * rest api 공통 응답 DTO
 *
 * @author smmoon
 * @since 2025-03-25
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = 8371380860370944955L;

    @Builder.Default
    private String code = ResultCode.SUCCESS.getCode();
    @Builder.Default
    private String message = ResultCode.SUCCESS.getMessage();
    private Object data;
    @Builder.Default
    private String detail = "";
    private Long rowTotCount;

    public static ResponseDTO of(String code, String message, String detail){
        return ResponseDTO.builder()
                .code(code)
                .message(message)
                .detail(detail)
                .build();
    }

    public static ResponseDTO of(ErrorCode errorCode, String detail){
        return of(errorCode.getCode(), errorCode.getMessage(), detail);
    }

    public static ResponseDTO success(Object data){
        return ResponseDTO.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static ResponseDTO success(Object data, String message){
        return ResponseDTO.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(message)
                .data(data)
                .build();
    }

}
