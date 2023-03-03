package com.myxny44.exchange.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "exchangeoperations")
public class ExchangeOperation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "amount")
    @Getter @Setter
    private Double amount;

    @Column(name = "summ")
    @Getter @Setter
    private Double summ;
    @Column(name = "operationdate")
    @Getter @Setter
    private Date operationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operatorid", nullable = false)
    @Getter @Setter
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rateid", nullable = false)
    @Getter @Setter
    private Rate rate;

}
