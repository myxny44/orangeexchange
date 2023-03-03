package com.myxny44.exchange.database.repository;

import com.myxny44.exchange.database.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

    @Query("SELECT o FROM Operator o WHERE o.company.id = :companyId")
    List<Operator> findByCompany(@Param("companyId") Long companyId);

}
