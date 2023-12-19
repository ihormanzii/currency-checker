package com.ihormanzii.currency.checker.utils;

import com.ihormanzii.currency.checker.models.CurrencyCode;
import org.springframework.stereotype.Component;

@Component
public final class CurrencyCodeUtil {

    public static String resolveCurrencyCode(Integer currencyCode) {
        String fromCurrencyCode = CurrencyCode.fromCurrencyName(currencyCode);
        if(fromCurrencyCode != null) {
            return fromCurrencyCode;
        }

        return currencyCode.toString();
    }
}
