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

import static com.ihormanzii.currency.checker.utils.CurrencyCodeUtil.resolveCurrencyCode;

@Slf4j
@Service
public class MonobankCurrencyService implements CurrencyService {

    @Autowired
    private MonobankAPIClient monobankAPIClient;

    @Override
    public CurrencyDTO getCurrency(String currencyName) {
        return monobankAPIClient.getCurrency().stream()
                .filter(c -> CurrencyCode.fromCurrencyName(c.getCurrencyCodeA()).equalsIgnoreCase(currencyName))
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
        List<CurrencyDTO> result = new ArrayList<>();
        fetchedCurrency.forEach(c -> {
            result.add(CurrencyDTO.builder()
                    .currencyName(resolveCurrencyCode(c.getCurrencyCodeA()))
                    .rateBuy(c.getRateBuy())
                    .rateSell(c.getRateSell())
                    .build());
        });

        return result;
    }
}
