package com.myxny44.exchange.requestentity;

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

}
