package com.myxny44.exchange.domain.service.interfaces;

import com.myxny44.exchange.domain.requestentity.RateResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RateService {

    List<RateResponseEntity> getRates();

    List<RateResponseEntity> getByCompany(Long companyId);

    List<RateResponseEntity> getByDate(String date);

    void addRate(List<RateResponseEntity> rateResponseEntityList);

}
