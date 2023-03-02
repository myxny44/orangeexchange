package com.myxny44.exchange.database.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "cashboxes")
public class CashBox {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false, name = "name")
    @Getter
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", nullable = false)
    private Company company;

}
