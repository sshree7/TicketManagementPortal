package com.nagarro.training.TicketManagementPortal.profileConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("datasource")
public class DatabaseConfiguration {
	private String driverClassName;

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println(driverClassName);
		return "DB connection for dev";
	}

	@Profile("uat")
	@Bean
	public String prodDatabaseConnection() {
		System.out.println(driverClassName);
		return "DB connection for uat";
	}
}
