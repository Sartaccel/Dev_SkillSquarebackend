package com.skillsquares.skillsquares.webapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssessmentResponse {

    private Long assessmentId;

    private Long candidateId;

    private String candidateName;

    private Integer attemptNo;

    private Integer aptitudeScore;

    private Integer communicationScore;

    private Integer technicalScore;

    private Integer totalScore;

    private Integer timeTakenSeconds;

    private String message;

}