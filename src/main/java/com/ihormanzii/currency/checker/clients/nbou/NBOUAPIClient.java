package com.ihormanzii.currency.checker.clients.nbou;

import com.ihormanzii.currency.checker.clients.monobank.dto.CurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "NationalBankOfUkraine", url = "https://bank.gov.ua")
public interface NBOUAPIClient {

    @GetMapping(path = "/NBUStatService/v1/statdirectory/exchange?json")
    List<CurrencyDTO> getCurrency();
}
