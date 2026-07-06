package com.skillsquares.skillsquares.webapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssessmentRequest {

    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Aptitude score is required")
    private Integer aptitudeScore;

    @NotNull(message = "Communication score is required")
    private Integer communicationScore;

    @NotNull(message = "Technical score is required")
    private Integer technicalScore;

    @NotNull(message = "Time taken is required")
    private Integer timeTakenSeconds;

}