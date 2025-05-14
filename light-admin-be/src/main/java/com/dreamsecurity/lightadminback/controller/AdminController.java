package com.dreamsecurity.lightadminback.controller;

import com.dreamsecurity.lightadminback.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminController
 *
 * @author smmoon
 * @since 2025-04-08
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @PostMapping("/adminList")
    //@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public ResponseEntity getAdminList(){
        return ResponseEntity.ok(ResponseDTO.success("list"));
    }

}
