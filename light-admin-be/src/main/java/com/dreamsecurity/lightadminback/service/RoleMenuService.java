package com.dreamsecurity.lightadminback.service;

import java.util.List;
/**
 * RoleMenuService
 *
 * @author smmoon
 * @since 2025-04-18
 */
public interface RoleMenuService {

    /**
     * 역할별 인가 url
     * @param roleList
     * @return
     */
    public List findAllowedUrisByRoles(List<String> roleList);
}
