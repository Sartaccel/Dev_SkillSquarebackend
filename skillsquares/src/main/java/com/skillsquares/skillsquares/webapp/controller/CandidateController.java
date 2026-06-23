package com.skillsquares.skillsquares.webapp.controller;

import com.skillsquares.skillsquares.webapp.entity.Candidate;
import com.skillsquares.skillsquares.webapp.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public Candidate saveCandidate(
            @Valid @RequestBody Candidate candidate) {

        return candidateRepository.save(candidate);
    }
}