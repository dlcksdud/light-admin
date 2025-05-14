package com.dreamsecurity.lightadminback.controller;

import com.dreamsecurity.lightadminback.aop.annotation.AuditLog;
import com.dreamsecurity.lightadminback.common.enums.EventType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping("/home")
    @AuditLog(eventType = EventType.LOGIN, page = "HOME")
    public String home(){
        int result = 1 / 0;
        return "home";
    }
}
