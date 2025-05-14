package com.dreamsecurity.lightadminback.service;

import com.dreamsecurity.lightadminback.repository.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RoleMenuServiceImpl
 *
 * @author smmoon
 * @since 2025-04-18
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService{

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public List findAllowedUrisByRoles(List<String> roleList) {
        return roleMenuMapper.findAllowedUrisByRoles(roleList);
    }
}
