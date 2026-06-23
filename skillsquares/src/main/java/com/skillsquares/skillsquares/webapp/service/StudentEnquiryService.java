
package com.skillsquares.skillsquares.webapp.service;
import com.skillsquares.skillsquares.webapp.entity.StudentEnquiry;
import com.skillsquares.skillsquares.webapp.repository.StudentEnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentEnquiryService {
    private final StudentEnquiryRepository repository;

    public StudentEnquiry save(StudentEnquiry enquiry) {
        return repository.save(enquiry);
    }

    public List<StudentEnquiry> getAll() {
        return repository.findAll();
    }
}