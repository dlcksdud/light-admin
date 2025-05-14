package com.dreamsecurity.lightadminback.aop.aspect;

import com.dreamsecurity.lightadminback.aop.annotation.AuditLog;
import com.dreamsecurity.lightadminback.aop.service.AuditLogService;
import com.dreamsecurity.lightadminback.common.enums.ResultCode;
import com.dreamsecurity.lightadminback.dto.AuditLogDTO;
import com.dreamsecurity.lightadminback.common.enums.EventType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AuditLogAspect {

    private final AuditLogService auditLogService;
    private final ObjectMapper objectMapper;

    @Around("@annotation(auditLog)")
    public Object logAudit(ProceedingJoinPoint joinPoint, AuditLog auditLog) throws Throwable {
        HttpServletRequest request = getCurrentHttpRequest();
        String requestUri = request != null ? request.getRequestURI() : "unknown";

        // 요청 파라미터 로깅
        Object[] args = joinPoint.getArgs();
        String requestData = Arrays.stream(args)
                .map(arg -> arg != null ? arg.toString() : "null")
                .collect(Collectors.joining(", "));

        log.info("[AUDIT] 호출 시작 - Page: {}, Event: {}, URI: {}, Request: {}",
                auditLog.page(), auditLog.eventType(), requestUri, requestData);

        Object result;
        try {
            result = joinPoint.proceed();

            String responseData = objectMapper.writeValueAsString(result);

            AuditLogDTO dto = AuditLogDTO.of(
                    ResultCode.SUCCESS,
                    auditLog.eventType(),
                    auditLog.page(),
                    requestData,
                    responseData
            );

            log.info("[AUDIT] SUCCESS - [{}] {}, Event: {}, Page: {}",
                    dto.getCode(), dto.getResultMessage(), dto.getEventType(), dto.getPage());


            auditLogService.save(dto);
            return result;
        } catch (Throwable e) {
            AuditLogDTO dto = AuditLogDTO.of(
                    ResultCode.FAILED,
                    auditLog.eventType(),
                    auditLog.page(),
                    requestData,
                    ""
            );

            log.error("[AUDIT] FAILED  - [{}] {}, Event: {}, Page: {}",
                    dto.getCode(),
                    dto.getResultMessage(),
                    dto.getEventType(),
                    dto.getPage(),
                    e);

            auditLogService.save(dto);
            throw e;
        }
    }

    private HttpServletRequest getCurrentHttpRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }
}
