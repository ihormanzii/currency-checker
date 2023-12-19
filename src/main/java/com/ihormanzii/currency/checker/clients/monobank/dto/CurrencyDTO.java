package com.ihormanzii.currency.checker.clients.monobank.dto;

import lombok.Data;

@Data
public class CurrencyDTO {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private Long date;
    private Double rateSell;
    private Double rateBuy;
    private Double rateCross;
}
