
package com.skillsquares.skillsquares.webapp.service;
import com.skillsquares.skillsquares.webapp.entity.CorporateEnquiry;
import com.skillsquares.skillsquares.webapp.repository.CorporateEnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CorporateEnquiryService {
    private final CorporateEnquiryRepository repository;

    public CorporateEnquiry save(CorporateEnquiry enquiry) {
        return repository.save(enquiry);
    }

    public List<CorporateEnquiry> getAll() {
        return repository.findAll();
    }
}