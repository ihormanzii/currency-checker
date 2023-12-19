package com.ihormanzii.currency.checker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCheckerApplication.class, args);
	}

}
