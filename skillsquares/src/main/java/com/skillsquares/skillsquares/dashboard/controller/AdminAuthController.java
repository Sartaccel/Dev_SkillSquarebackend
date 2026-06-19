package com.skillsquares.skillsquares.dashboard.controller;

import com.skillsquares.skillsquares.dashboard.dto.LoginRequest;
import com.skillsquares.skillsquares.dashboard.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminAuthController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        boolean valid = adminService.login(request);

        if (valid) {
            return ResponseEntity.ok(
                    Map.of(
                            "success", true,
                            "message", "Login Successful"
                    )
            );
        }

        return ResponseEntity.status(401).body(
                Map.of(
                        "success", false,
                        "message", "Invalid Credentials"
                )
        );
    }
}