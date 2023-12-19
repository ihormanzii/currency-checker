package com.ihormanzii.currency.checker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum CurrencyCode {
    US("US", 840),
    EUR("EUR", 978),
    UAH("UAH", 980);

    private final String currencyName;
    private final Integer currencyCode;

    public static String fromCurrencyName(Integer currencyCode) {
        return Arrays.stream(values())
                .filter(c -> c.getCurrencyCode().equals(currencyCode))
                .findFirst()
                .map(CurrencyCode::getCurrencyName)
                .orElse(null);
    }

}
