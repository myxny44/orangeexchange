package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.entity.Charge;
import com.myxny44.exchange.database.repository.CashBoxRepository;
import com.myxny44.exchange.database.repository.ChargeRepository;
import com.myxny44.exchange.database.repository.OperatorRepository;
import com.myxny44.exchange.requestentity.ChargeRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChargeController {

    @Autowired
    private ChargeRepository chargeRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private CashBoxRepository cashBoxRepository;

    @GetMapping("/api/charge")
    public ResponseEntity<List<ChargeRequestEntity>> getCharges() {
        return ResponseEntity.ok(
                chargeRepository
                        .findAll()
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/api/charge/date/{date}")
    public ResponseEntity<List<ChargeRequestEntity>> getChargesByDate(@PathVariable String date) {
        return ResponseEntity.ok(
                chargeRepository
                        .findByDate(date)
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }


    @GetMapping("/api/charge/cashbox/{cashBoxId}")
    public ResponseEntity<List<ChargeRequestEntity>> getChargesByCashBox(@PathVariable Long cashBoxId) {
        return ResponseEntity.ok(
                chargeRepository
                        .findByCashBox(cashBoxId)
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }


    @GetMapping("/api/charge/operator/{operatorId}")
    public ResponseEntity<List<ChargeRequestEntity>> getChargesByOperator(@PathVariable Long operatorId) {
        return ResponseEntity.ok(
                chargeRepository
                        .findByOperator(operatorId)
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/api/charge")
    public ResponseEntity<?> startCharge(@RequestBody ChargeRequestEntity chargeRequestEntity){
        chargeRepository.save(toDbEntity(chargeRequestEntity));
        return ResponseEntity.noContent().build();
    }

    private ChargeRequestEntity toRequestEntity(Charge charge) {
        ChargeRequestEntity chargeRequestEntity = new ChargeRequestEntity();
        chargeRequestEntity.setId(charge.getId());
        chargeRequestEntity.setOperatorId(charge.getOperator().getId());
        chargeRequestEntity.setCashBoxId(charge.getCashBox().getId());
        chargeRequestEntity.setOperatorName(charge.getOperator().getDisplayname());
        chargeRequestEntity.setCashBoxName(charge.getCashBox().getName());
        chargeRequestEntity.setChargeDate(charge.getChargedate());
        return chargeRequestEntity;
    }

    private Charge toDbEntity(ChargeRequestEntity chargeRequestEntity) {
        Charge charge = new Charge();
        charge.setId(chargeRequestEntity.getId());
        charge.setOperator(operatorRepository.getById(chargeRequestEntity.getOperatorId()));
        charge.setCashBox(cashBoxRepository.getById(chargeRequestEntity.getCashBoxId()));
        charge.setChargedate(chargeRequestEntity.getChargeDate());
        return charge;
    }

}
