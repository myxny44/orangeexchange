package com.myxny44.exchange.data.entity;

import com.myxny44.exchange.domain.requestentity.ExchangeOperationRequestEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "exchangeoperations")
public class ExchangeOperation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "amount")
    @Getter @Setter
    private Double amount;

    @Column(name = "summ")
    @Getter @Setter
    private Double summ;
    @Column(name = "operationdate")
    @Getter @Setter
    private Date operationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operatorid", nullable = false)
    @Getter @Setter
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rateid", nullable = false)
    @Getter @Setter
    private Rate rate;

    public ExchangeOperationRequestEntity toRequestEntity() {
        ExchangeOperationRequestEntity exchangeOperationRequestEntity = new ExchangeOperationRequestEntity();
        exchangeOperationRequestEntity.setId(this.getId());
        exchangeOperationRequestEntity.setOperationDate(this.getOperationDate());
        exchangeOperationRequestEntity.setOperatorId(this.getOperator().getId());
        exchangeOperationRequestEntity.setCurs(this.getRate().getCurs());
        exchangeOperationRequestEntity.setAmount(this.getAmount());
        exchangeOperationRequestEntity.setOperatorDisplayName(this.getOperator().getDisplayname());
        exchangeOperationRequestEntity.setRateId(this.getRate().getId());
        exchangeOperationRequestEntity.setCodValuta(this.getRate().getCodValuta());
        exchangeOperationRequestEntity.setSumm(this.getSumm());
        return exchangeOperationRequestEntity;
    }

}
