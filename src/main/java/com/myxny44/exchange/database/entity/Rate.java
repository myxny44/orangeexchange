package com.myxny44.exchange.database.entity;

import lombok.Getter;
import lombok.Setter;

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
    @Getter @Setter
    private String codValuta;

    @Column(name = "curs")
    @Getter @Setter
    private Double curs;

    @Column(name = "ratedate")
    @Getter @Setter
    private Date rateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", nullable = false)
    @Getter @Setter
    private Company company;

}
