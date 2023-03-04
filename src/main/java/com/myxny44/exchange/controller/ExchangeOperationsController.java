package com.myxny44.exchange.controller;

import com.myxny44.exchange.domain.requestentity.ExchangeOperationRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.ExchangeOperationService;
import com.myxny44.exchange.domain.service.ExchangeOperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExchangeOperationsController {

    @Autowired
    private final ExchangeOperationService exchangeOperationService = new ExchangeOperationServiceImpl();

    @GetMapping("/api/exchange")
    public ResponseEntity<List<ExchangeOperationRequestEntity>> getOperations() {
        return ResponseEntity.ok(exchangeOperationService.getOperations());
    }

    @GetMapping("/api/exchange/operator/{operatorid}")
    public ResponseEntity<List<ExchangeOperationRequestEntity>> getOperations(@PathVariable Long operatorid) {
        return ResponseEntity.ok(exchangeOperationService.getOperations(operatorid));
    }

    @PostMapping("/api/exchange")
    public ResponseEntity<ExchangeOperationRequestEntity> newExchange(@RequestBody ExchangeOperationRequestEntity exchangeOperationRequestEntity) {
        return ResponseEntity.ok(exchangeOperationService.newExchange(exchangeOperationRequestEntity));
    }

    @PutMapping("/api/exchange")
    public ResponseEntity<ExchangeOperationRequestEntity> updateExchangeOperation(@RequestBody ExchangeOperationRequestEntity exchangeOperationRequestEntity) {
        return ResponseEntity.ok(exchangeOperationService.updateExchangeOperation(exchangeOperationRequestEntity));
    }

}
