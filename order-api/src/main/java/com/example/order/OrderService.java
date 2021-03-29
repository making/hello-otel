package com.example.order;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {
	private final RestTemplate restTemplate;

	private final OrderProps props;

	public OrderService(RestTemplateBuilder restTemplateBuilder, OrderProps props) {
		this.restTemplate = restTemplateBuilder.build();
		this.props = props;
	}

	public Order createOrder(Order order) {
		try {
			this.restTemplate.postForEntity(this.props.getPaymentUrl(), Map.of("price", order.getPrice()), JsonNode.class);
			return order;
		}
		catch (RestClientResponseException e) {
			throw new ResponseStatusException(e.getRawStatusCode(), e.getStatusText(), e);
		}
	}
}
