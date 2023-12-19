package com.ihormanzii.currency.checker.services.impl;

import com.ihormanzii.currency.checker.models.CurrencyDTO;
import com.ihormanzii.currency.checker.services.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NBOUCurrencyService implements CurrencyService {
    @Override
    public CurrencyDTO getCurrency(String currencyName) {
        return null;
    }

    @Override
    public List<CurrencyDTO> getCurrency() {
        return null;
    }
}
