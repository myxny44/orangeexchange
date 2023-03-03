package com.myxny44.exchange.requestentity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class ChargeRequestEntity {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long operatorId;

    @Getter @Setter
    private String operatorName;

    @Getter @Setter
    private Long cashBoxId;

    @Getter @Setter
    private String cashBoxName;

    @Getter @Setter
    private Date chargeDate;

}
