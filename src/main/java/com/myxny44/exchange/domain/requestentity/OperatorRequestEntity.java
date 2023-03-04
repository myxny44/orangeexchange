package com.myxny44.exchange.domain.requestentity;

import com.myxny44.exchange.data.entity.Operator;
import com.myxny44.exchange.data.repository.CompaniesRepository;
import lombok.Getter;
import lombok.Setter;

public class OperatorRequestEntity {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String displayName;

    @Getter @Setter
    private Long companyId;

    @Getter @Setter
    private String companyName;

    public Operator toDbEntity(CompaniesRepository companiesRepository) {
        Operator operator = new Operator();
        operator.setId(this.getId());
        operator.setDisplayname(this.getDisplayName());
        operator.setCompany(companiesRepository.getById(this.getCompanyId()));
        return operator;
    }

}
