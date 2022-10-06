package com.everis.bootcamp.productservice.service;

import com.everis.bootcamp.productservice.dto.Product;

public interface ProductServiceI {
	
	public Product getProduct(Integer id);

	public Product postProduct(Integer id);
}
