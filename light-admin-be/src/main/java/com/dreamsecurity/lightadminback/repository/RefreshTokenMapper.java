package com.dreamsecurity.lightadminback.repository;

import com.dreamsecurity.lightadminback.dto.RefreshTokenDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * RefreshTokenMapper
 *
 * @author smmoon
 * @since 2025-03-28
 */
@Mapper
public interface RefreshTokenMapper {
    RefreshTokenDTO findByUserId(@Param("userId") String userId);
    void insertOrUpdate(RefreshTokenDTO refreshTokenDTO);
    void deleteByUserId(@Param("userId") String userId);
}
