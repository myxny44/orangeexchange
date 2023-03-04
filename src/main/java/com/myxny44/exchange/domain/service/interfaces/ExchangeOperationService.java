package com.myxny44.exchange.domain.service.interfaces;

import com.myxny44.exchange.domain.requestentity.ExchangeOperationRequestEntity;

import java.util.List;

public interface ExchangeOperationService {

    List<ExchangeOperationRequestEntity> getOperations();

    List<ExchangeOperationRequestEntity> getOperations(Long operatorid);

    ExchangeOperationRequestEntity newExchange(ExchangeOperationRequestEntity exchangeOperationRequestEntity);

    ExchangeOperationRequestEntity updateExchangeOperation(ExchangeOperationRequestEntity exchangeOperationRequestEntity);

}
