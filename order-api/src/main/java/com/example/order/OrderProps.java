package com.example.order;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "order")
@ConstructorBinding
public class OrderProps {
	private final String paymentUrl;

	public OrderProps(@DefaultValue("http://localhost:7071") String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}
}
