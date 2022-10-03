package com.everis.bootcamp.productservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	/**
	 * Url de acceso http://localhost:8888/product-service-pro/default
	 * Url de acceso http://localhost:8888/product-service-dev/default
	 * Url de acceso http://localhost:8888/product-service/default
	 */
	
	@Value("${product.product-name}")
	private String nombreProducto;
	
	@GetMapping(path = "/product")
	public String nombreProducto() {
		return this.nombreProducto;
		
	}
}
