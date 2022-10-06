package com.everis.bootcamp.productservice.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.everis.bootcamp.productservice.dto.Prices;
import com.everis.bootcamp.productservice.dto.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Primary
public class ProductServiceRemoteImpl implements ProductServiceI {

	/*@Value("${bootcamp.service.product-service.endpoint}")
	private String endpoint;*/

	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	@CircuitBreaker(name = "default", fallbackMethod = "fallBack")
	public Product getProduct(Integer id) {
		if (id != null) {
			Product producto = new Product();
			final Prices response = this.restTemplate.getForObject("http://localhost:8080/producto/", Prices.class, id);
			producto.setProductId(response.getId());
			producto.setChannel(response.getDescription());
			producto.setPort(response.getCode_product());
			producto.setPrice(new BigDecimal(response.getPrice().toString()));
			return producto;

		} else {
			return null;
		}
	}
	@Override
	@CircuitBreaker(name = "default", fallbackMethod = "fallBack")
	public Product postProduct(Integer id) {
		if (id != null) {
			Product producto = new Product();
			final Prices response = this.restTemplate.postForObject("http://localhost:8080/producto/" + id,null, Prices.class, id);
			producto.setProductId(response.getId());
			producto.setChannel(response.getDescription());
			producto.setPort(response.getCode_product());
			producto.setPrice(new BigDecimal(response.getPrice().toString()));
			return producto;

		} else {
			return null;
		}
	}
	
	public Product fallBack(Integer id, Throwable e) {
		Product producto = new Product();
		producto.setProductId(null);
		producto.setChannel("None");
		producto.setPort("None");
		producto.setPrice(null);
		return producto;
	}

}
