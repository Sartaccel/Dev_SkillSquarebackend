
package com.skillsquares.skillsquares.webapp.repository;
import com.skillsquares.skillsquares.webapp.entity.StudentEnquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnquiryRepository extends JpaRepository<StudentEnquiry, Long> {}