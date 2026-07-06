package com.skillsquares.skillsquares.webapp.controller;

import com.skillsquares.skillsquares.webapp.dto.AssessmentRequest;
import com.skillsquares.skillsquares.webapp.dto.AssessmentResponse;
import com.skillsquares.skillsquares.webapp.service.AssessmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}