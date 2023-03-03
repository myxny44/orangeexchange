package com.myxny44.exchange.database.entity;

import com.myxny44.exchange.requestentity.CashBoxRequestEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cashboxes")
public class CashBox {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(nullable = false, name = "name")
    @Getter @Setter
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", nullable = false)
    @Getter @Setter
    private Company company;

    public CashBoxRequestEntity toRequestEntity(){
        CashBoxRequestEntity entity = new CashBoxRequestEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCompanyid(this.company.getId());

        return entity;
    }

}
