package com.myxny44.exchange.domain.requestentity;

import com.myxny44.exchange.data.entity.CashBox;
import com.myxny44.exchange.data.repository.CompaniesRepository;
import lombok.Getter;
import lombok.Setter;

public class CashBoxRequestEntity {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Long companyid;

    public CashBox toDbEntity(CompaniesRepository companiesRepository) {
        CashBox cashBox = new CashBox();
        cashBox.setName(this.getName());
        cashBox.setCompany(companiesRepository.getById(this.getCompanyid()));
        return cashBox;
    }

}
