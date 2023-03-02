package com.myxny44.exchange.database.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "exchangeoperations")
public class ExchangeOperation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operatorid", nullable = false)
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rateid", nullable = false)
    private Rate rateid;

}
