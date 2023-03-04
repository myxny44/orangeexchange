package com.myxny44.exchange.domain.service.interfaces;

import com.myxny44.exchange.domain.requestentity.CashBoxRequestEntity;

import java.util.List;

public interface CashBoxService {

    List<CashBoxRequestEntity> getAllCashBox();

    List<CashBoxRequestEntity> getCashBoxByCompanyId(Long companyId);

    CashBoxRequestEntity editCashBox(CashBoxRequestEntity cashBoxRequestEntity);

    void deleteCashBox(List<CashBoxRequestEntity> cashBoxRequestEntityList);

    void addCashBox(List<CashBoxRequestEntity> cashBoxRequestEntityList);

}
