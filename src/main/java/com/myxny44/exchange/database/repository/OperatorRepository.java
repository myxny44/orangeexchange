package com.myxny44.exchange.database.repository;

import com.myxny44.exchange.database.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {
}
