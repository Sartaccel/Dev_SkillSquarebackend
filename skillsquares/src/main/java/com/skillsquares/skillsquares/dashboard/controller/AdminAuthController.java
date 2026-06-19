package com.skillsquares.skillsquares.dashboard.controller;

import com.skillsquares.skillsquares.dashboard.dto.LoginRequest;
import com.skillsquares.skillsquares.dashboard.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminAuthController {

    @Autowired
    private AdminAuthService adminAuthService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return adminAuthService.login(request);
    }
}