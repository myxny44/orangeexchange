package com.myxny44.exchange.controller;

import com.myxny44.exchange.domain.requestentity.ChargeRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.ChargeService;
import com.myxny44.exchange.domain.service.ChargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ChargeController {

    @Autowired
    private final ChargeService chargeService = new ChargeServiceImpl();

    @GetMapping("/api/charge")
    public ResponseEntity<List<ChargeRequestEntity>> getCharges() {
        return ResponseEntity.ok(chargeService.getCharges());
    }

    @GetMapping("/api/charge/date/{date}")
    public ResponseEntity<List<ChargeRequestEntity>> getChargesByDate(@PathVariable Date date) {
        return ResponseEntity.ok(chargeService.getChargesByDate(date));
    }


    @GetMapping("/api/charge/cashbox/{cashBoxId}")
    public ResponseEntity<List<ChargeRequestEntity>> getChargesByCashBox(@PathVariable Long cashBoxId) {
        return ResponseEntity.ok(chargeService.getChargesByCashBox(cashBoxId));
    }

    @GetMapping("/api/charge/operator/{operatorId}")
    public ResponseEntity<List<ChargeRequestEntity>> getChargesByOperator(@PathVariable Long operatorId) {
        return ResponseEntity.ok(chargeService.getChargesByOperator(operatorId));
    }

    @PostMapping("/api/charge")
    public ResponseEntity<?> startCharge(@RequestBody ChargeRequestEntity chargeRequestEntity){
        chargeService.startCharge(chargeRequestEntity);
        return ResponseEntity.noContent().build();
    }

}
