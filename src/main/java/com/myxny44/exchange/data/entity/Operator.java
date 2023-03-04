package com.myxny44.exchange.data.entity;

import com.myxny44.exchange.domain.requestentity.OperatorRequestEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "operators")
public class Operator {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(nullable = false, name = "displayname")
    @Getter @Setter
    private String displayname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", nullable = false)
    @Getter @Setter
    private Company company;


    public OperatorRequestEntity toRequestEntity() {
        OperatorRequestEntity operatorRequestEntity = new OperatorRequestEntity();
        operatorRequestEntity.setId(this.getId());
        operatorRequestEntity.setCompanyName(this.getCompany().getName());
        operatorRequestEntity.setCompanyId(this.getCompany().getId());
        operatorRequestEntity.setDisplayName(this.getDisplayname());
        return operatorRequestEntity;
    }

}
