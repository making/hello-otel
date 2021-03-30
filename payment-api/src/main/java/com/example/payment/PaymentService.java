package com.example.payment;

import java.math.BigDecimal;

import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	private final JdbcTemplate jdbcTemplate;

	public PaymentService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@NewSpan
	public boolean authorize(BigDecimal price) {
		final Integer limit = this.jdbcTemplate.queryForObject("SELECT 100", Integer.class);
		return price.compareTo(BigDecimal.valueOf(limit)) <= 0;
	}
}
