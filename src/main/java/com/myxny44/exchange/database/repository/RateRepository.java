package com.myxny44.exchange.database.repository;

import com.myxny44.exchange.database.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query("SELECT r FROM Rate r WHERE r.company.id = :companyid")
    List<Rate> findByCompany(@Param("companyid") Long companyId);

    @Query("SELECT r FROM Rate r WHERE r.rateDate = :ratedate")
    List<Rate> findByDate(@Param("ratedate") String rateDate);

}
