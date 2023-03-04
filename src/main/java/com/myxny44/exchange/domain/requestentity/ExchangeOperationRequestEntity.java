package com.myxny44.exchange.domain.requestentity;

import com.myxny44.exchange.data.entity.ExchangeOperation;
import com.myxny44.exchange.data.repository.OperatorRepository;
import com.myxny44.exchange.data.repository.RateRepository;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class ExchangeOperationRequestEntity {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long rateId;

    @Getter @Setter
    private Long operatorId;

    @Getter @Setter
    private String codValuta;

    @Getter @Setter
    private String operatorDisplayName;

    @Getter @Setter
    private Double curs;

    @Getter @Setter
    private Double amount;

    @Getter @Setter
    private Double summ;

    @Getter @Setter
    private Date operationDate;

    public ExchangeOperation toDbEntity(OperatorRepository operatorRepository, RateRepository rateRepository) {
        ExchangeOperation exchangeOperation = new ExchangeOperation();
        exchangeOperation.setId(this.getId());
        exchangeOperation.setAmount(this.getAmount());
        exchangeOperation.setOperationDate(this.getOperationDate());
        exchangeOperation.setSumm(this.getSumm());
        exchangeOperation.setOperator(operatorRepository.getById(this.getOperatorId()));
        exchangeOperation.setRate(rateRepository.getById(this.getRateId()));
        return exchangeOperation;
    }

}
