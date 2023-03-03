package com.myxny44.exchange.requestentity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class RateResponseEntity {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String codValuta;

    @Getter @Setter
    private Double curs;

    @Getter @Setter
    private Date rateDate;

    @Getter @Setter
    private Long companyId;

    @Getter @Setter
    private String companyName;

}
