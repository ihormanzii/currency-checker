package com.ihormanzii.currency.checker.controllers;

import com.ihormanzii.currency.checker.models.CurrencyDTO;
import com.ihormanzii.currency.checker.services.impl.NBOUCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nbou/currency")
public class NbouCurrencyController {

    @Autowired
    private NBOUCurrencyService nbouCurrencyService;

    @GetMapping()
    public List<CurrencyDTO> getCurrency() {
        return nbouCurrencyService.getCurrency();
    }

    @GetMapping("/{currencyName}")
    public CurrencyDTO getCurrency(@PathVariable String currencyName) {
        return nbouCurrencyService.getCurrency(currencyName);
    }
}
