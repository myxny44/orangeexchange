package com.myxny44.exchange.controller;

import com.myxny44.exchange.domain.requestentity.CashBoxRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.CashBoxService;
import com.myxny44.exchange.domain.service.CashBoxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CashBoxController {

    @Autowired
    private final CashBoxService cashBoxService = new CashBoxServiceImpl();

    @GetMapping("/api/cashbox")
    public ResponseEntity<List<CashBoxRequestEntity>> getCashBox() {
        return ResponseEntity.ok(cashBoxService.getAllCashBox());
    }

    @GetMapping("/api/cashbox/{companyId}")
    public ResponseEntity<List<CashBoxRequestEntity>> getCashBoxByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(cashBoxService.getCashBoxByCompanyId(companyId));
    }

    @PostMapping("/api/cashbox")
    public ResponseEntity<?> addCashBox(@RequestBody List<CashBoxRequestEntity> cashBoxRequestEntityList) {
        cashBoxService.addCashBox(cashBoxRequestEntityList);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cashbox")
    public ResponseEntity<CashBoxRequestEntity> editCashBox(@RequestBody CashBoxRequestEntity cashBoxRequestEntity) {
        cashBoxService.editCashBox(cashBoxRequestEntity);
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/cashbox")
    public ResponseEntity<?> deleteCashBox(@RequestBody List<Long> ids) {
        cashBoxService.deleteCashBox(ids);
        return ResponseEntity.noContent().build();
    }

}
