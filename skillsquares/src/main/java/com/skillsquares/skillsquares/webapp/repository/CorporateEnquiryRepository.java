
package com.skillsquares.skillsquares.webapp.repository;
import com.skillsquares.skillsquares.webapp.entity.CorporateEnquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateEnquiryRepository extends JpaRepository<CorporateEnquiry, Long> {}