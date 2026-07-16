package com.skillsquares.skillsquares.webapp.repository;

import com.skillsquares.skillsquares.webapp.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    // Used in AssessmentService
    Optional<Candidate> findByEmail(String email);

    // Used in CandidateController
    long countByEmail(String email);
}