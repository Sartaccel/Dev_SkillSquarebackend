package com.skillsquares.skillsquares.webapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full Name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;

    private String mobileNumber;

    @NotBlank(message = "College is required")
    private String college;

    @NotBlank(message = "Studies is required")
    private String studies;

    @NotBlank(message = "Department is required")
    private String department;
}