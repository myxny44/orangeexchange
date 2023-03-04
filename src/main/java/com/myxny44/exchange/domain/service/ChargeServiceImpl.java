package com.myxny44.exchange.domain.service;

import com.myxny44.exchange.data.entity.Charge;
import com.myxny44.exchange.data.repository.CashBoxRepository;
import com.myxny44.exchange.data.repository.ChargeRepository;
import com.myxny44.exchange.data.repository.OperatorRepository;
import com.myxny44.exchange.domain.requestentity.ChargeRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChargeServiceImpl implements ChargeService {


    @Autowired
    private ChargeRepository chargeRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private CashBoxRepository cashBoxRepository;


    @Override
    public List<ChargeRequestEntity> getCharges() {
        return chargeRepository
                .findAll()
                .stream()
                .map(Charge::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargeRequestEntity> getChargesByDate(Date date) {
        return chargeRepository
                .findByDate(date)
                .stream()
                .map(Charge::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargeRequestEntity> getChargesByCashBox(Long cashBoxId) {
        return chargeRepository
                .findByCashBox(cashBoxId)
                .stream()
                .map(Charge::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargeRequestEntity> getChargesByOperator(Long operatorId) {
        return chargeRepository
                .findByOperator(operatorId)
                .stream()
                .map(Charge::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void startCharge(ChargeRequestEntity chargeRequestEntity) {
        chargeRepository.save(chargeRequestEntity.toDbEntity(cashBoxRepository, operatorRepository));
    }
}
