package com.myxny44.exchange.domain.service.interfaces;

import com.myxny44.exchange.domain.requestentity.ChargeRequestEntity;

import java.util.List;

public interface ChargeService {

    List<ChargeRequestEntity> getCharges();

    List<ChargeRequestEntity> getChargesByDate(String date);

    List<ChargeRequestEntity> getChargesByCashBox(Long cashBoxId);

    List<ChargeRequestEntity> getChargesByOperator(Long operatorId);

    void startCharge(ChargeRequestEntity chargeRequestEntity);

}
