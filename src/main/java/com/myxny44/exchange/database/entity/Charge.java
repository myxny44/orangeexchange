package com.myxny44.exchange.database.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "charges")
public class Charge {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "chargedate")
    private Date chargedate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashboxid", nullable = false)
    private CashBox cashBox;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operatorid", nullable = false)
    private Operator operator;

}
