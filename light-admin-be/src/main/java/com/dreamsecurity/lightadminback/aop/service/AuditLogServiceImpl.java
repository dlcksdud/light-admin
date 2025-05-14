package com.dreamsecurity.lightadminback.aop.service;

import com.dreamsecurity.lightadminback.dto.AuditLogDTO;
import com.dreamsecurity.lightadminback.repository.AuditLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogMapper auditLogMapper;

    @Override
    public void save(AuditLogDTO dto) {
        auditLogMapper.insertAuditLog(dto);  // DTO를 직접 전달
    }
}
