package com.ihormanzii.currency.checker.clients.monobank;

import com.ihormanzii.currency.checker.clients.monobank.dto.CurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "monobank", url = "https://api.monobank.ua")
public interface MonobankAPIClient {

    @GetMapping(path = "/bank/currency")
    List<CurrencyDTO> getCurrency();
}
