package com.myxny44.exchange.domain.service;

import com.myxny44.exchange.data.entity.CashBox;
import com.myxny44.exchange.data.repository.CashBoxRepository;
import com.myxny44.exchange.data.repository.CompaniesRepository;
import com.myxny44.exchange.domain.requestentity.CashBoxRequestEntity;
import com.myxny44.exchange.domain.service.interfaces.CashBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CashBoxServiceImpl implements CashBoxService {

    @Autowired
    private CashBoxRepository cashBoxRepository;
    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public List<CashBoxRequestEntity> getAllCashBox() {
        return cashBoxRepository.findAll()
                .stream()
                .map(CashBox::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CashBoxRequestEntity> getCashBoxByCompanyId(Long companyId) {
        return cashBoxRepository.findByCompany(companyId)
                .stream()
                .map(CashBox::toRequestEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CashBoxRequestEntity editCashBox(CashBoxRequestEntity cashBoxRequestEntity) {
        return cashBoxRepository.save(
                cashBoxRequestEntity
                        .toDbEntity(companiesRepository)
        ).toRequestEntity();
    }

    @Override
    public void deleteCashBox(List<CashBoxRequestEntity> cashBoxRequestEntityList) {
        cashBoxRepository.deleteAll(cashBoxRequestEntityList.stream()
                .map( cashBoxRequestEntity -> cashBoxRequestEntity.toDbEntity(companiesRepository) )
                .collect(Collectors.toList()));
    }

    @Override
    public void addCashBox(List<CashBoxRequestEntity> cashBoxRequestEntityList) {
        cashBoxRepository.saveAll(cashBoxRequestEntityList.stream()
                .map( cashBoxRequestEntity -> cashBoxRequestEntity.toDbEntity(companiesRepository) )
                .collect(Collectors.toList()));
    }
}
