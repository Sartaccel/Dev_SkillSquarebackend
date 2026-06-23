
package com.skillsquares.skillsquares.webapp.service;
import com.skillsquares.skillsquares.webapp.entity.CollegeEnquiry;
import com.skillsquares.skillsquares.webapp.repository.CollegeEnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeEnquiryService {
    private final CollegeEnquiryRepository repository;

    public CollegeEnquiry save(CollegeEnquiry enquiry) {
        return repository.save(enquiry);
    }

    public List<CollegeEnquiry> getAll() {
        return repository.findAll();
    }
}