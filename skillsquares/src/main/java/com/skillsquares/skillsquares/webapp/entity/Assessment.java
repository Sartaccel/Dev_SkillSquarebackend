package com.skillsquares.skillsquares.webapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "candidate_assessments")
@Getter
@Setter
@NoArgsConstructor
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship with Candidate table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @Column(nullable = false)
    private Integer attemptNo;

    @Column(nullable = false)
    private Integer aptitudeScore;

    @Column(nullable = false)
    private Integer communicationScore;

    @Column(nullable = false)
    private Integer technicalScore;

    @Column(nullable = false)
    private Integer totalScore;

    @Column(nullable = false)
    private Integer timeTakenSeconds;

    @Column(nullable = false)
    private LocalDateTime assessmentDate;
}