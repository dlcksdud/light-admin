package com.dreamsecurity.lightadminback.aop.service;

import com.dreamsecurity.lightadminback.dto.AuditLogDTO;

public interface AuditLogService {
    void save(AuditLogDTO dto);
}
