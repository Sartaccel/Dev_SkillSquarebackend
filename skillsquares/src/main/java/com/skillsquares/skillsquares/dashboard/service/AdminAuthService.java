package com.skillsquares.skillsquares.dashboard.service;

import com.skillsquares.skillsquares.dashboard.dto.LoginRequest;
import com.skillsquares.skillsquares.dashboard.dto.LoginResponse;
import com.skillsquares.skillsquares.dashboard.entity.Admin;
import com.skillsquares.skillsquares.dashboard.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<LoginResponse> login(LoginRequest request) {

        Admin admin = adminRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (admin == null || !passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            return ResponseEntity.status(401)
                    .body(new LoginResponse("Invalid credentials", false));
        }

        return ResponseEntity.ok(
                new LoginResponse("Login successful", true)
        );
    }
}