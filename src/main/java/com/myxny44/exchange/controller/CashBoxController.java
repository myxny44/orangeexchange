package com.myxny44.exchange.controller;

import com.myxny44.exchange.database.repository.CashBoxRepository;
import com.myxny44.exchange.database.repository.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class CashBoxController {

    @Autowired
    private CashBoxRepository cashBoxRepository;
    @Autowired
    private CompaniesRepository companiesRepository;


}
