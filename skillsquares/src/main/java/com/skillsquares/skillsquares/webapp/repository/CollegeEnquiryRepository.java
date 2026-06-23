
package com.skillsquares.skillsquares.webapp.repository;
import com.skillsquares.skillsquares.webapp.entity.CollegeEnquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeEnquiryRepository extends JpaRepository<CollegeEnquiry, Long> {}