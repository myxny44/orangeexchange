package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.entity.CashBox;
import com.myxny44.exchange.database.repository.CashBoxRepository;
import com.myxny44.exchange.database.repository.CompaniesRepository;
import com.myxny44.exchange.requestentity.CashBoxRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CashBoxController {

    @Autowired
    private CashBoxRepository cashBoxRepository;
    @Autowired
    private CompaniesRepository companiesRepository;

    @GetMapping("/api/cashbox")
    public ResponseEntity<List<CashBoxRequestEntity>> getCashBox() {
        List<CashBoxRequestEntity> cashBoxes = cashBoxRepository.findAll()
                .stream()
                .map(CashBox::toRequestEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cashBoxes);
    }

    @GetMapping("/api/cashbox/{companyId}")
    public ResponseEntity<List<CashBoxRequestEntity>> getCashBoxByCompanyId(@PathVariable Long companyId) {
        List<CashBoxRequestEntity> cashBoxes = cashBoxRepository.findByCompany(companyId)
                .stream()
                .map(CashBox::toRequestEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cashBoxes);
    }

    @PostMapping("/api/cashbox")
    public ResponseEntity<?> addCashBox(@RequestBody List<CashBoxRequestEntity> cashBoxRequestEntityList) {
        cashBoxRepository.saveAll(cashBoxRequestEntityList.stream()
                .map(this::toDbEntity)
                .collect(Collectors.toList()));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cashbox")
    public ResponseEntity<CashBoxRequestEntity> editCashBox(@RequestBody CashBoxRequestEntity cashBoxRequestEntity) {
        if (cashBoxRepository.existsById(cashBoxRequestEntity.getId())) {
            return ResponseEntity.ok(cashBoxRepository.save(toDbEntity(cashBoxRequestEntity)).toRequestEntity());
        } else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/cashbox")
    public ResponseEntity<?> deleteCashBox(@RequestBody List<CashBoxRequestEntity> cashBoxRequestEntityList) {
        cashBoxRepository.deleteAll(cashBoxRequestEntityList.stream()
                .map(this::toDbEntity)
                .collect(Collectors.toList()));
        return ResponseEntity.noContent().build();
    }

    private CashBox toDbEntity(CashBoxRequestEntity cashBoxRequestEntity) {
        CashBox cashBox = new CashBox();
        cashBox.setName(cashBoxRequestEntity.getName());
        cashBox.setCompany(companiesRepository.getById(cashBoxRequestEntity.getCompanyid()));
        return cashBox;
    }

}
