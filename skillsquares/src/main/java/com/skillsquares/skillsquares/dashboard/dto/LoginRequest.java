package com.skillsquares.skillsquares.dashboard.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}