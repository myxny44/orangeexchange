package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.entity.Operator;
import com.myxny44.exchange.database.repository.CompaniesRepository;
import com.myxny44.exchange.database.repository.OperatorRepository;
import com.myxny44.exchange.requestentity.OperatorRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OperatorController {

    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private CompaniesRepository companiesRepository;

    @GetMapping("/api/operator")
    public ResponseEntity<List<OperatorRequestEntity>> getOperators() {
        return ResponseEntity.ok(
                operatorRepository
                        .findAll()
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/api/operator/{companyId}")
    public ResponseEntity<List<OperatorRequestEntity>> getOperatorsByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(
                operatorRepository
                        .findByCompany(companyId)
                        .stream()
                        .map(this::toRequestEntity)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/api/operator")
    public ResponseEntity<?> createOperator(@RequestBody List<OperatorRequestEntity> operatorRequestEntityList) {
        operatorRepository.saveAll(
            operatorRequestEntityList
                    .stream()
                    .map(this::toDbEntity)
                    .collect(Collectors.toList())
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/operator")
    public ResponseEntity<?> deleteOperator(@RequestBody List<OperatorRequestEntity> operatorRequestEntityList){
        operatorRepository.deleteAll(
                operatorRequestEntityList
                        .stream()
                        .map(this::toDbEntity)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.noContent().build();
    }

    private OperatorRequestEntity toRequestEntity(Operator operator) {
        OperatorRequestEntity operatorRequestEntity = new OperatorRequestEntity();
        operatorRequestEntity.setId(operator.getId());
        operatorRequestEntity.setCompanyName(operator.getCompany().getName());
        operatorRequestEntity.setCompanyId(operator.getCompany().getId());
        operatorRequestEntity.setDisplayName(operator.getDisplayname());
        return operatorRequestEntity;
    }

    private Operator toDbEntity(OperatorRequestEntity operatorRequestEntity) {
        Operator operator = new Operator();
        operator.setId(operatorRequestEntity.getId());
        operator.setDisplayname(operatorRequestEntity.getDisplayName());
        operator.setCompany(companiesRepository.getById(operatorRequestEntity.getCompanyId()));
        return operator;
    }

}
