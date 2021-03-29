package com.example.payment;

import org.apache.catalina.filters.RequestDumperFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApiApplication.class, args);
	}

	@Bean
	public RequestDumperFilter requestDumperFilter() {
		return new RequestDumperFilter();
	}

}
