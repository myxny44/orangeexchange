package com.myxny44.exchange.data.repository;

import com.myxny44.exchange.data.entity.CashBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashBoxRepository extends JpaRepository<CashBox, Long> {

    @Query("SELECT c FROM CashBox c WHERE c.company.id = :companyid")
    List<CashBox> findByCompany(@Param("companyid") Long companyId);

}
