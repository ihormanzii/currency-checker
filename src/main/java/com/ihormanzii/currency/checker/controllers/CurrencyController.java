package com.ihormanzii.currency.checker.controllers;

import com.ihormanzii.currency.checker.models.CurrencyDTO;
import com.ihormanzii.currency.checker.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public List<CurrencyDTO> getCurrency() {
        return currencyService.getCurrency();
    }

    @GetMapping("/currency/{currencyName}")
    public CurrencyDTO getCurrency(@PathVariable String currencyName) {
        return currencyService.getCurrency(currencyName);
    }
}
