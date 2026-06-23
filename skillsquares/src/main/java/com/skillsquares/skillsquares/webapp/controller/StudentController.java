
package com.skillsquares.skillsquares.webapp.controller;
import com.skillsquares.skillsquares.webapp.entity.StudentEnquiry;
import com.skillsquares.skillsquares.webapp.service.StudentEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enquiry/student")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class StudentController {

    private final StudentEnquiryService service;

    @PostMapping
    public ResponseEntity<StudentEnquiry> submit(@RequestBody StudentEnquiry enquiry) {
        StudentEnquiry saved = service.save(enquiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<StudentEnquiry>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}