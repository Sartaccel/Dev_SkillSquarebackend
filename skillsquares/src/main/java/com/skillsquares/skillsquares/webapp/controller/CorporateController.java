
package com.skillsquares.skillsquares.webapp.controller;


import com.skillsquares.skillsquares.webapp.entity.CorporateEnquiry;
import com.skillsquares.skillsquares.webapp.service.CorporateEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enquiry/corporate")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CorporateController {

    private final CorporateEnquiryService service;

    @PostMapping
    public ResponseEntity<CorporateEnquiry> submit(@RequestBody CorporateEnquiry enquiry) {
        CorporateEnquiry saved = service.save(enquiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CorporateEnquiry>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}