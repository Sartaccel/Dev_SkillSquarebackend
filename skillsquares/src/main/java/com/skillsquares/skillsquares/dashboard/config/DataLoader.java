package com.skillsquares.skillsquares.dashboard.config;

import com.skillsquares.skillsquares.dashboard.entity.Admin;
import com.skillsquares.skillsquares.dashboard.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (adminRepository.findByUsername("admin").isEmpty()) {

            Admin admin = new Admin();
            admin.setUsername("admin");

            // encrypt password
            admin.setPassword(passwordEncoder.encode("admin123"));

            admin.setRole("ADMIN");

            adminRepository.save(admin);
        }
    }
}