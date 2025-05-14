package com.dreamsecurity.lightadminback.repository;

import com.dreamsecurity.lightadminback.dto.AuditLogDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuditLogMapper {
    void insertAuditLog(AuditLogDTO dto);
}