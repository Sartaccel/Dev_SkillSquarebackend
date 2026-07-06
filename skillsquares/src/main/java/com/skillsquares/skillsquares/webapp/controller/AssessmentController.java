package com.skillsquares.skillsquares.webapp.controller;

import com.skillsquares.skillsquares.webapp.dto.AssessmentRequest;
import com.skillsquares.skillsquares.webapp.dto.AssessmentResponse;
import com.skillsquares.skillsquares.webapp.service.AssessmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/submit")
    public AssessmentResponse submitAssessment(
            @Valid @RequestBody AssessmentRequest request) {

        return assessmentService.submitAssessment(request);
    }

    @GetMapping("/attempts")
    public Map<String, Long> getAttempts(@RequestParam String email) {
        long attemptsUsed = assessmentService.getAttemptsUsed(email);
        return Map.of("attemptsUsed", attemptsUsed);
    }
}