package com.myxny44.exchange.controller;

import com.myxny44.exchange.domain.requestentity.RateResponseEntity;
import com.myxny44.exchange.domain.service.interfaces.RateService;
import com.myxny44.exchange.domain.service.RateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class RateController {

    @Autowired
    private final RateService rateService = new RateServiceImpl();

    @GetMapping("/api/rate")
    public ResponseEntity<List<RateResponseEntity>> getRates() {
        return ResponseEntity.ok(rateService.getRates());
    }

    @GetMapping("/api/rate/company/{companyId}")
    public ResponseEntity<List<RateResponseEntity>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(rateService.getByCompany(companyId));
    }

    @GetMapping("/api/rate/date/{date}")
    public ResponseEntity<List<RateResponseEntity>> getByDate(@PathVariable Date date){
        return ResponseEntity.ok(rateService.getByDate(date));
    }

    @PostMapping("/api/rate")
    public ResponseEntity<?> addRate(@RequestBody List<RateResponseEntity> rateResponseEntityList){
        rateService.addRate(rateResponseEntityList);
        return ResponseEntity.noContent().build();
    }

}
