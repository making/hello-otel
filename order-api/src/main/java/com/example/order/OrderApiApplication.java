package com.example.order;

import org.apache.catalina.filters.RequestDumperFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan
@SpringBootApplication
public class OrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApiApplication.class, args);
	}

	@Bean
	public RequestDumperFilter requestDumperFilter() {
		return new RequestDumperFilter();
	}
}
