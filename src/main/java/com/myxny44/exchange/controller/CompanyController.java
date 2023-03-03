package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.repository.CompaniesRepository;
import com.myxny44.exchange.database.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompaniesRepository companiesRepository;

    @GetMapping("/api/company")
    public List<Company> getCompany() {
        return companiesRepository.findAll();
    }

    @PostMapping("/api/company")
    public ResponseEntity<?> addCompany(@RequestBody Company company) {
        companiesRepository.save(company);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/company")
    public ResponseEntity<Company> editCompany(@RequestBody Company company) {
        if (companiesRepository.existsById(company.getId()))
            return ResponseEntity.ok(companiesRepository.save(company));
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/company")
    public ResponseEntity<?> deleteCompany(@RequestBody List<Long> companyIds) {
        companiesRepository.deleteAllById(companyIds);
        return ResponseEntity.noContent().build();
    }

}
