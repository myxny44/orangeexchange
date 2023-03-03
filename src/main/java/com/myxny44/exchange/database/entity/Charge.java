package com.myxny44.exchange.database.entity;

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

}
