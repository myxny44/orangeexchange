package com.myxny44.exchange.requestentity;

import com.myxny44.exchange.database.entity.Company;
import lombok.Getter;
import lombok.Setter;

public class CashBoxRequestEntity {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Long companyid;

}
