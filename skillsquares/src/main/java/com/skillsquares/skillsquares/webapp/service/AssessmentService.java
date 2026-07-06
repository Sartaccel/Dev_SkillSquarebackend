package com.skillsquares.skillsquares.webapp.service;

import com.skillsquares.skillsquares.webapp.dto.AssessmentRequest;
import com.skillsquares.skillsquares.webapp.dto.AssessmentResponse;
import com.skillsquares.skillsquares.webapp.entity.Assessment;
import com.skillsquares.skillsquares.webapp.entity.Candidate;
import com.skillsquares.skillsquares.webapp.repository.AssessmentRepository;
import com.skillsquares.skillsquares.webapp.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public AssessmentResponse submitAssessment(AssessmentRequest request) {

        // Find candidate using email
        Candidate candidate = candidateRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        // Count previous attempts
        long attempts = assessmentRepository.countByCandidateEmail(request.getEmail());

        // Allow only two attempts
        if (attempts >= 2) {
            throw new RuntimeException("Maximum 2 assessment attempts are allowed.");
        }

        // Calculate total score
        int totalScore = request.getAptitudeScore()
                + request.getCommunicationScore()
                + request.getTechnicalScore();

        // Create Assessment object
        Assessment assessment = new Assessment();

        assessment.setCandidate(candidate);
        assessment.setAttemptNo((int) attempts + 1);
        assessment.setAptitudeScore(request.getAptitudeScore());
        assessment.setCommunicationScore(request.getCommunicationScore());
        assessment.setTechnicalScore(request.getTechnicalScore());
        assessment.setTotalScore(totalScore);
        assessment.setTimeTakenSeconds(request.getTimeTakenSeconds());
        assessment.setAssessmentDate(LocalDateTime.now());

        // Save into database
        Assessment savedAssessment = assessmentRepository.save(assessment);

        // Prepare response
        AssessmentResponse response = new AssessmentResponse();

        response.setAssessmentId(savedAssessment.getId());
        response.setCandidateId(candidate.getId());
        response.setCandidateName(candidate.getFullName());
        response.setAttemptNo(savedAssessment.getAttemptNo());
        response.setAptitudeScore(savedAssessment.getAptitudeScore());
        response.setCommunicationScore(savedAssessment.getCommunicationScore());
        response.setTechnicalScore(savedAssessment.getTechnicalScore());
        response.setTotalScore(savedAssessment.getTotalScore());
        response.setTimeTakenSeconds(savedAssessment.getTimeTakenSeconds());
        response.setMessage("Assessment submitted successfully.");

        return response;
    }

}