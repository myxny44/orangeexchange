package com.myxny44.exchange.requestentity;

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

}
