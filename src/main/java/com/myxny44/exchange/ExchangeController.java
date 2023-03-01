package com.myxny44.exchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExchangeController {

    @GetMapping("/api/rates")
    public List<ExchangeRate> getRates() {
        List<ExchangeRate> rates = new ArrayList<ExchangeRate>() ;
        ExchangeRate rate = new ExchangeRate();
        rate.setName("USD");
        rate.setRate(18.8775);
        rates.add(rate);
        return rates;
    }

}
