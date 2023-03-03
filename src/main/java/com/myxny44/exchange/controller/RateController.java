package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.entity.Rate;
import com.myxny44.exchange.database.repository.CompaniesRepository;
import com.myxny44.exchange.database.repository.RateRepository;
import com.myxny44.exchange.requestentity.RateResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RateController {

    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private CompaniesRepository companiesRepository;

    @GetMapping("/api/rate")
    public ResponseEntity<List<RateResponseEntity>> getRates() {
        return ResponseEntity.ok(
                rateRepository
                        .findAll()
                        .stream()
                        .map(this::toResponseEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/api/rate/company/{companyId}")
    public ResponseEntity<List<RateResponseEntity>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(
                rateRepository.findByCompany(companyId)
                        .stream()
                        .map(this::toResponseEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/api/rate/date/{date}")
    public ResponseEntity<List<RateResponseEntity>> getByDate(@PathVariable String date){
        return ResponseEntity.ok(
                rateRepository.findByDate(date)
                        .stream()
                        .map(this::toResponseEntity)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/api/rate")
    public ResponseEntity<?> addRate(@RequestBody List<RateResponseEntity> rateResponseEntityList){
        rateRepository.saveAll(
                rateResponseEntityList
                        .stream()
                        .map(this::toDbEntity)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.noContent().build();
    }


    private RateResponseEntity toResponseEntity(Rate rate) {
        RateResponseEntity rateResponseEntity = new RateResponseEntity();
        rateResponseEntity.setId(rate.getId());
        rateResponseEntity.setRateDate(rate.getRateDate());
        rateResponseEntity.setCurs(rate.getCurs());
        rateResponseEntity.setCodValuta(rate.getCodValuta());
        rateResponseEntity.setCompanyName(rate.getCompany().getName());
        rateResponseEntity.setCompanyId(rateResponseEntity.getCompanyId());
        return rateResponseEntity;
    }

    private Rate toDbEntity(RateResponseEntity rateResponseEntity){
        Rate rate = new Rate();
        rate.setRateDate(rateResponseEntity.getRateDate());
        rate.setCurs(rateResponseEntity.getCurs());
        rate.setCodValuta(rateResponseEntity.getCodValuta());
        rate.setCompany(companiesRepository.getById(rateResponseEntity.getCompanyId()));
        return rate;
    }
}
