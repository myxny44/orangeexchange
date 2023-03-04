package com.myxny44.exchange.controller;

import com.myxny44.exchange.data.entity.Company;
import com.myxny44.exchange.domain.service.CompanyServiceImpl;
import com.myxny44.exchange.domain.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private final CompanyService companyService = new CompanyServiceImpl();

    @GetMapping("/api/company")
    public ResponseEntity<?> getCompany() {
        return new ResponseEntity<>(companyService.getCompany(), HttpStatus.OK);
    }

    @PostMapping("/api/company")
    public ResponseEntity<?> addCompany(@RequestBody List<Company> company) {
        companyService.addCompany(company);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/company")
    public ResponseEntity<Company> editCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.editCompany(company));
    }

    @DeleteMapping("/api/company")
    public ResponseEntity<?> deleteCompany(@RequestBody List<Long> companyIds) {
        companyService.deleteCompany(companyIds);
        return ResponseEntity.noContent().build();
    }

}
