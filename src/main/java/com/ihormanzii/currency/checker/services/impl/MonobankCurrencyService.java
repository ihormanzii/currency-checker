package com.ihormanzii.currency.checker.services.impl;

import com.ihormanzii.currency.checker.clients.monobank.MonobankAPIClient;
import com.ihormanzii.currency.checker.models.CurrencyCode;
import com.ihormanzii.currency.checker.models.CurrencyDTO;
import com.ihormanzii.currency.checker.services.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
@Service
public class MonobankCurrencyService implements CurrencyService {

    @Autowired
    private MonobankAPIClient monobankAPIClient;

    @Override
    public CurrencyDTO getCurrency(String currencyName) {
        return monobankAPIClient.getCurrency().stream()
                .filter(matchToRequestedCurrencyName(currencyName))
                .findFirst()
                .map(c -> CurrencyDTO.builder()
                        .currencyName(currencyName)
                        .rateBuy(c.getRateBuy())
                        .rateSell(c.getRateSell())
                        .build())
                .orElseThrow();
    }

    @Override
    public List<CurrencyDTO> getCurrency() {
        var fetchedCurrency = monobankAPIClient.getCurrency();
        List<CurrencyDTO> resultCurrency = new ArrayList<>();

        fetchedCurrency.forEach(c -> resultCurrency.add(CurrencyDTO.builder()
                        .currencyName(CurrencyCode.fromCurrencyName(c.getCurrencyCodeA()))
                        .rateBuy(c.getRateBuy())
                        .rateSell(c.getRateSell())
                .build()));

        return resultCurrency;
    }

    private static Predicate<com.ihormanzii.currency.checker.clients.monobank.dto.CurrencyDTO> matchToRequestedCurrencyName(String currencyName) {
        return c -> c.getCurrencyCodeA().equals(CurrencyCode.valueOf(currencyName).getCurrencyCode());
    }
}
