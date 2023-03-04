package com.myxny44.exchange.domain.service.interfaces;

import com.myxny44.exchange.domain.requestentity.OperatorRequestEntity;

import java.util.List;

public interface OperatorService {

    List<OperatorRequestEntity> getOperators();

    List<OperatorRequestEntity> getOperatorsByCompany(Long companyId);

    void createOperator(List<OperatorRequestEntity> operatorRequestEntityList);

    void deleteOperator(List<OperatorRequestEntity> operatorRequestEntityList);

}
