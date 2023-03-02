package com.myxny44.exchange.database.repository;

import com.myxny44.exchange.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Long> {
}
