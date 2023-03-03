package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.entity.ExchangeOperation;
import com.myxny44.exchange.database.entity.Rate;
import com.myxny44.exchange.database.repository.ExchangeOperationsRepository;
import com.myxny44.exchange.database.repository.OperatorRepository;
import com.myxny44.exchange.database.repository.RateRepository;
import com.myxny44.exchange.requestentity.ExchangeOperationRequestEntity;
import com.myxny44.exchange.requestentity.OperatorRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExchangeOperationsController {

    @Autowired
    private ExchangeOperationsRepository exchangeOperationsRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private RateRepository rateRepository;

    @GetMapping("/api/exchange")
    public ResponseEntity<List<ExchangeOperationRequestEntity>> getOperations() {
        return ResponseEntity.ok(
                exchangeOperationsRepository
                        .findAll()
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/api/exchange/operator/{operatorid}")
    public ResponseEntity<List<ExchangeOperationRequestEntity>> getOperations(@PathVariable Long operatorid) {
        return ResponseEntity.ok(
                exchangeOperationsRepository
                        .findByOperator(operatorid)
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/api/exchange")
    public ResponseEntity<ExchangeOperationRequestEntity> newExchange(@RequestBody ExchangeOperationRequestEntity exchangeOperationRequestEntity) {
        Rate rate = rateRepository.getById(exchangeOperationRequestEntity.getRateId());
        exchangeOperationRequestEntity.setSumm(
                exchangeOperationRequestEntity.getAmount() * rate.getCurs()
        );
        exchangeOperationsRepository.save(toDbEntity(exchangeOperationRequestEntity));
        return ResponseEntity.ok(exchangeOperationRequestEntity);
    }

    private ExchangeOperationRequestEntity toRequestEntity(ExchangeOperation exchangeOperation) {
        ExchangeOperationRequestEntity exchangeOperationRequestEntity = new ExchangeOperationRequestEntity();
        exchangeOperationRequestEntity.setId(exchangeOperation.getId());
        exchangeOperationRequestEntity.setOperationDate(exchangeOperation.getOperationDate());
        exchangeOperationRequestEntity.setOperatorId(exchangeOperation.getOperator().getId());
        exchangeOperationRequestEntity.setCurs(exchangeOperation.getRate().getCurs());
        exchangeOperationRequestEntity.setAmount(exchangeOperation.getAmount());
        exchangeOperationRequestEntity.setOperatorDisplayName(exchangeOperation.getOperator().getDisplayname());
        exchangeOperationRequestEntity.setRateId(exchangeOperation.getRate().getId());
        exchangeOperationRequestEntity.setCodValuta(exchangeOperation.getRate().getCodValuta());
        exchangeOperationRequestEntity.setSumm(exchangeOperation.getSumm());
        return exchangeOperationRequestEntity;
    }

    private ExchangeOperation toDbEntity(ExchangeOperationRequestEntity exchangeOperationRequestEntity) {
        ExchangeOperation exchangeOperation = new ExchangeOperation();
        exchangeOperation.setId(exchangeOperationRequestEntity.getId());
        exchangeOperation.setAmount(exchangeOperationRequestEntity.getAmount());
        exchangeOperation.setOperationDate(exchangeOperationRequestEntity.getOperationDate());
        exchangeOperation.setSumm(exchangeOperationRequestEntity.getSumm());
        exchangeOperation.setOperator(operatorRepository.getById(exchangeOperationRequestEntity.getOperatorId()));
        exchangeOperation.setRate(rateRepository.getById(exchangeOperationRequestEntity.getRateId()));
        return exchangeOperation;
    }

}
