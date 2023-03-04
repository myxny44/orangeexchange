package com.myxny44.exchange.domain.service;

import com.myxny44.exchange.data.entity.Rate;
import com.myxny44.exchange.data.repository.CompaniesRepository;
import com.myxny44.exchange.data.repository.RateRepository;
import com.myxny44.exchange.domain.requestentity.RateResponseEntity;
import com.myxny44.exchange.domain.service.interfaces.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public List<RateResponseEntity> getRates() {
        return rateRepository
                .findAll()
                .stream()
                .map(Rate::toResponseEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<RateResponseEntity> getByCompany(Long companyId) {
        return rateRepository.findByCompany(companyId)
                .stream()
                .map(Rate::toResponseEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<RateResponseEntity> getByDate(Date date) {
        return rateRepository.findByDate(date)
                .stream()
                .map(Rate::toResponseEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void addRate(List<RateResponseEntity> rateResponseEntityList) {
        rateRepository.saveAll(
                rateResponseEntityList
                        .stream()
                        .map(rateResponseEntity -> rateResponseEntity.toDbEntity(companiesRepository))
                        .collect(Collectors.toList())
        );
    }
}
