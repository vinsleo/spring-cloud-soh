package com.vinsleo.stockonhand.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StockOnHandSourceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockOnHandSourceAppApplication.class, args);
	}
}
