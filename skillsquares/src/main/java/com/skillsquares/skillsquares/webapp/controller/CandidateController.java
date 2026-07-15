package com.skillsquares.skillsquares.webapp.controller;

import com.skillsquares.skillsquares.webapp.entity.Candidate;
import com.skillsquares.skillsquares.webapp.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public ResponseEntity<?> saveCandidate(@Valid @RequestBody Candidate candidate) {

        long attemptCount = candidateRepository.countByEmail(candidate.getEmail());

        if (attemptCount >= 2) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Maximum 2 assessment attempts are allowed for this email.");
        }

        Candidate savedCandidate = candidateRepository.save(candidate);

        return ResponseEntity.ok(savedCandidate);
    }
}