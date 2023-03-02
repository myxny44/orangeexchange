package com.myxny44.exchange.database.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "operators")
public class Operator {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false, name = "username")
    @Getter
    private String username;

    @Column(nullable = false, name = "password")
    @Getter
    private String password;

    @Column(nullable = false, name = "displayname")
    @Getter
    private String displayname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", nullable = false)
    private Company company;

}
