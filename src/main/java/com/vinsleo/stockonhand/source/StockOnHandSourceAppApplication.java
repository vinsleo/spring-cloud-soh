package com.vinsleo.stockonhand.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.stream.app.sftp.source.SftpSourceConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ImportAutoConfiguration(SftpSourceConfiguration.class)
public class StockOnHandSourceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockOnHandSourceAppApplication.class, args);
	}
}
