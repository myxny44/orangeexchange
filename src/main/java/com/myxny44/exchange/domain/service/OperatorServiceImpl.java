package com.myxny44.exchange.domain.service;

import com.myxny44.exchange.data.entity.Operator;
import com.myxny44.exchange.data.repository.CompaniesRepository;
import com.myxny44.exchange.data.repository.OperatorRepository;
import com.myxny44.exchange.domain.requestentity.OperatorRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private CompaniesRepository companiesRepository;


    @Override
    public List<OperatorRequestEntity> getOperators() {
        return operatorRepository
                .findAll()
                .stream()
                .map(Operator::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OperatorRequestEntity> getOperatorsByCompany(Long companyId) {
        return operatorRepository
                .findByCompany(companyId)
                .stream()
                .map(Operator::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void createOperator(List<OperatorRequestEntity> operatorRequestEntityList) {
        operatorRepository.saveAll(
                operatorRequestEntityList
                        .stream()
                        .map(operatorRequestEntity -> operatorRequestEntity.toDbEntity(companiesRepository))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteOperator(List<OperatorRequestEntity> operatorRequestEntityList) {
        operatorRepository.deleteAll(
                operatorRequestEntityList
                        .stream()
                        .map(operatorRequestEntity -> operatorRequestEntity.toDbEntity(companiesRepository))
                        .collect(Collectors.toList())
        );
    }
}
