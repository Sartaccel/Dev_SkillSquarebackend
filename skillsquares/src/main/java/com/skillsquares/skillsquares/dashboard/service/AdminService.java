package com.skillsquares.skillsquares.dashboard.service;

import com.skillsquares.skillsquares.dashboard.dto.LoginRequest;
import com.skillsquares.skillsquares.dashboard.entity.Admin;
import com.skillsquares.skillsquares.dashboard.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public boolean login(LoginRequest request) {
        return "admin".equals(request.getUsername())
                && "admin123".equals(request.getPassword());
    }
}