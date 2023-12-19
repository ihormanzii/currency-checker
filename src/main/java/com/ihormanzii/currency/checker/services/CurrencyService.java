package com.ihormanzii.currency.checker.services;

import com.ihormanzii.currency.checker.models.CurrencyDTO;

import java.util.List;

public interface CurrencyService {
    CurrencyDTO getCurrency(String currencyName);

    List<CurrencyDTO> getCurrency();
}
