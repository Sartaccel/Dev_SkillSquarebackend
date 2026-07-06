package com.skillsquares.skillsquares.webapp.controller;

import com.skillsquares.skillsquares.webapp.entity.CollegeEnquiry;
import com.skillsquares.skillsquares.webapp.service.CollegeEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enquiry/college")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeEnquiryService service;

    @PostMapping
    public ResponseEntity<CollegeEnquiry> submit(@RequestBody CollegeEnquiry enquiry) {
        CollegeEnquiry saved = service.save(enquiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CollegeEnquiry>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}