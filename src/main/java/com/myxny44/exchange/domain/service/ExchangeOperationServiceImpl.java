package com.myxny44.exchange.domain.service;

import com.myxny44.exchange.data.entity.ExchangeOperation;
import com.myxny44.exchange.data.entity.Rate;
import com.myxny44.exchange.data.repository.ExchangeOperationsRepository;
import com.myxny44.exchange.data.repository.OperatorRepository;
import com.myxny44.exchange.data.repository.RateRepository;
import com.myxny44.exchange.domain.requestentity.ExchangeOperationRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.ExchangeOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeOperationServiceImpl implements ExchangeOperationService {

    @Autowired
    private ExchangeOperationsRepository exchangeOperationsRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<ExchangeOperationRequestEntity> getOperations() {
        return exchangeOperationsRepository
                .findAll()
                .stream()
                .map(ExchangeOperation::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExchangeOperationRequestEntity> getOperations(Long operatorid) {
        return exchangeOperationsRepository
                .findByOperator(operatorid)
                .stream()
                .map(ExchangeOperation::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ExchangeOperationRequestEntity newExchange(ExchangeOperationRequestEntity exchangeOperationRequestEntity) {
        Rate rate = rateRepository.getById(exchangeOperationRequestEntity.getRateId());
        exchangeOperationRequestEntity.setSumm(
                exchangeOperationRequestEntity.getAmount() * rate.getCurs()
        );
        return exchangeOperationsRepository.save(
                exchangeOperationRequestEntity.toDbEntity(operatorRepository, rateRepository)
        ).toRequestEntity();
    }

    @Override
    public ExchangeOperationRequestEntity updateExchangeOperation(ExchangeOperationRequestEntity exchangeOperationRequestEntity) {
        Rate rate = rateRepository.getById(exchangeOperationRequestEntity.getRateId());
        exchangeOperationRequestEntity.setSumm(
                exchangeOperationRequestEntity.getAmount() * rate.getCurs()
        );
        exchangeOperationsRepository.save(exchangeOperationRequestEntity.toDbEntity(operatorRepository, rateRepository));
        return exchangeOperationRequestEntity;
    }
}
