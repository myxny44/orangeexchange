package com.myxny44.exchange.domain.requestentity;

import com.myxny44.exchange.data.entity.Charge;
import com.myxny44.exchange.data.repository.CashBoxRepository;
import com.myxny44.exchange.data.repository.OperatorRepository;
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

    public Charge toDbEntity(CashBoxRepository cashBoxRepository, OperatorRepository operatorRepository) {
        Charge charge = new Charge();
        charge.setId(this.getId());
        charge.setOperator(operatorRepository.getById(this.getOperatorId()));
        charge.setCashBox(cashBoxRepository.getById(this.getCashBoxId()));
        charge.setChargedate(this.getChargeDate());
        return charge;
    }

}
