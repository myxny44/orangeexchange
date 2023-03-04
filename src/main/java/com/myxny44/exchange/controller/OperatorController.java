package com.myxny44.exchange.controller;

import com.myxny44.exchange.domain.requestentity.OperatorRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.OperatorService;
import com.myxny44.exchange.domain.service.OperatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OperatorController {

    @Autowired
    private final OperatorService operatorService = new OperatorServiceImpl();

    @GetMapping("/api/operator")
    public ResponseEntity<List<OperatorRequestEntity>> getOperators() {
        return ResponseEntity.ok(operatorService.getOperators());
    }

    @GetMapping("/api/operator/{companyId}")
    public ResponseEntity<List<OperatorRequestEntity>> getOperatorsByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(operatorService.getOperatorsByCompany(companyId));
    }

    @PostMapping("/api/operator")
    public ResponseEntity<?> createOperator(@RequestBody List<OperatorRequestEntity> operatorRequestEntityList) {
        operatorService.createOperator(operatorRequestEntityList);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/operator")
    public ResponseEntity<?> deleteOperator(@RequestBody List<OperatorRequestEntity> operatorRequestEntityList){
        operatorService.deleteOperator(operatorRequestEntityList);
        return ResponseEntity.noContent().build();
    }

}
