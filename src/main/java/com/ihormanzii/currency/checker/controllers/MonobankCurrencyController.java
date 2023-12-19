package com.ihormanzii.currency.checker.controllers;

import com.ihormanzii.currency.checker.models.CurrencyDTO;
import com.ihormanzii.currency.checker.services.impl.MonobankCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("monobank/currency")
public class MonobankCurrencyController {

    @Autowired
    private MonobankCurrencyService monobankCurrencyService;

    @GetMapping()
    public List<CurrencyDTO> getCurrency() {
        return monobankCurrencyService.getCurrency();
    }

    @GetMapping("/{currencyName}")
    public CurrencyDTO getCurrency(@PathVariable String currencyName) {
        return monobankCurrencyService.getCurrency(currencyName);
    }
}
