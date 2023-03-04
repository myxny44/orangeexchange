package com.myxny44.exchange.domain.service;

import com.myxny44.exchange.data.entity.Company;
import com.myxny44.exchange.data.repository.CompaniesRepository;
import com.myxny44.exchange.domain.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public List<Company> getCompany() {
        return companiesRepository.findAll();
    }

    @Override
    public void addCompany(List<Company> company) {
        companiesRepository.saveAll(company);
    }

    @Override
    public Company editCompany(Company company) {
        return companiesRepository.save(company);
    }

    @Override
    public void deleteCompany(List<Long> companyIds) {
        companiesRepository.deleteAllById(companyIds);
    }
}
