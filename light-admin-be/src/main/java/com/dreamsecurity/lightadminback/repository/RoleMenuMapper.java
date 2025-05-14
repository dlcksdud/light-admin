package com.dreamsecurity.lightadminback.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * RoleMenuMapper
 *
 * @author smmoon
 * @since 2025-04-18
 */
@Mapper
public interface RoleMenuMapper {
    List<String> findAllowedUrisByRoles(@Param("roles") List<String> roles);
}
