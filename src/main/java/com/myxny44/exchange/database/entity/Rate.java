package com.myxny44.exchange.database.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rates")
public class Rate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "codvaluta")
    private String codValuta;

    @Column(name = "curs")
    private Double curs;

    @Column(name = "ratedate")
    private Date rateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", nullable = false)
    private Company company;

}
