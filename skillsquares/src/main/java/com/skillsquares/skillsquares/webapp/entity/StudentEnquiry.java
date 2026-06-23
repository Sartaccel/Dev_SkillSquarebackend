package com.skillsquares.skillsquares.webapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_enquiries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEnquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    private String degreeCourse;

    @Column(columnDefinition = "TEXT")
    private String careerGoals;

    @Column(name = "submitted_at", updatable = false)
    private LocalDateTime submittedAt;

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
    }
}