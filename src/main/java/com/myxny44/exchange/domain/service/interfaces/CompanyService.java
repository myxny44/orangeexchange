package com.myxny44.exchange.domain.service.interfaces;

import com.myxny44.exchange.data.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompany();

    void addCompany(List<Company> company);

    Company editCompany(Company company);

    void deleteCompany(List<Long> companyIds);

}
