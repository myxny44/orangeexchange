package com.myxny44.exchange.data.entity;

import com.myxny44.exchange.domain.requestentity.ChargeRequestEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "charges")
public class Charge {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "chargedate")
    @Getter @Setter
    private Date chargedate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashboxid", nullable = false)
    @Getter @Setter
    private CashBox cashBox;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operatorid", nullable = false)
    @Getter @Setter
    private Operator operator;

    public ChargeRequestEntity toRequestEntity() {
        ChargeRequestEntity chargeRequestEntity = new ChargeRequestEntity();
        chargeRequestEntity.setId(this.getId());
        chargeRequestEntity.setOperatorId(this.getOperator().getId());
        chargeRequestEntity.setCashBoxId(this.getCashBox().getId());
        chargeRequestEntity.setOperatorName(this.getOperator().getDisplayname());
        chargeRequestEntity.setCashBoxName(this.getCashBox().getName());
        chargeRequestEntity.setChargeDate(this.getChargedate());
        return chargeRequestEntity;
    }

}
