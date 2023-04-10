package com.card.credit_card_mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.card.credit_card_mgmt", "org.springframework.web.context"})
public class CreditCardMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardMgmtApplication.class, args);
	}

}
