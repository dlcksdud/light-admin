package com.dreamsecurity.lightadminback.repository;

import com.dreamsecurity.lightadminback.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper
 *
 * @author smmoon
 * @since 2025-03-21
 */
@Mapper
public interface UserMapper {
    UserDTO findById(@Param("id") String id);
}
