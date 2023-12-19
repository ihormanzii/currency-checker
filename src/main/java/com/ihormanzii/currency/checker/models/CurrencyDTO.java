package com.ihormanzii.currency.checker.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyDTO {
    private String currencyName;
    private Double rateSell;
    private Double rateBuy;
}
