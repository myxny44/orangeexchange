package com.myxny44.exchange.domain.requestentity;

import com.myxny44.exchange.data.entity.Rate;
import com.myxny44.exchange.data.repository.CompaniesRepository;
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

    public Rate toDbEntity(CompaniesRepository companiesRepository){
        Rate rate = new Rate();
        rate.setRateDate(this.getRateDate());
        rate.setCurs(this.getCurs());
        rate.setCodValuta(this.getCodValuta());
        rate.setCompany(companiesRepository.getById(this.getCompanyId()));
        return rate;
    }

}
