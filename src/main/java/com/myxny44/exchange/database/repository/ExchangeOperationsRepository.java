package com.myxny44.exchange.database.repository;

import com.myxny44.exchange.database.entity.ExchangeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeOperationsRepository extends JpaRepository<ExchangeOperation, Long> {

    @Query("SELECT e FROM ExchangeOperation e WHERE e.operator.id = :operatorid")
    List<ExchangeOperation> findByOperator(@Param("operatorid") Long operatorid);

}
