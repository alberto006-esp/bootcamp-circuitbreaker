package com.everis.bootcamp.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bootcamp.productservice.dto.Product;
import com.everis.bootcamp.productservice.service.ProductServiceI;

@RestController()
public class ProductController {
	
	/**
     * Url de acceso
     * http://localhost:8080/api/producto
     */

    private final String URL = "/api/producto";
	
	private ProductServiceI productServiceI;

	public ProductController(ProductServiceI productServiceI) {
		this.productServiceI = productServiceI;
	}
	
	@GetMapping(URL + "/{id}")
	public Product getProduct(@PathVariable Integer id) {
		return productServiceI.getProduct(id);
	}
	
	@PostMapping(URL +"/{id}")
	public Product postProduct(@PathVariable Integer id) {
		return productServiceI.postProduct(id);
	}
}
