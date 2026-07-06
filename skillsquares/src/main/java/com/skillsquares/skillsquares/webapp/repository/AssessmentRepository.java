package com.skillsquares.skillsquares.webapp.repository;

import com.skillsquares.skillsquares.webapp.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    // Count the number of attempts by candidate email
    long countByCandidateEmail(String email);

    // Get all attempts of a candidate
    List<Assessment> findByCandidateEmailOrderByAttemptNo(String email);

}