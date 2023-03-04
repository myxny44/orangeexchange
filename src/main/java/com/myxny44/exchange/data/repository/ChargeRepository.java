package com.myxny44.exchange.data.repository;

import com.myxny44.exchange.data.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {

    @Query("SELECT c FROM Charge c WHERE c.chargedate = :chargedate")
    List<Charge> findByDate(@Param("chargedate") String chargeDate);

    @Query("SELECT c FROM Charge c WHERE c.operator.id = :operatorid")
    List<Charge> findByOperator(@Param("operatorid") Long operatorId);

    @Query("SELECT c FROM Charge c WHERE c.cashBox.id = :cashboxid")
    List<Charge> findByCashBox(@Param("cashboxid") Long cashBoxId);

}
