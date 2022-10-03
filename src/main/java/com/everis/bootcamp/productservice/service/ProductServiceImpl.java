package com.everis.bootcamp.productservice.service;

import org.springframework.stereotype.Service;

import com.everis.bootcamp.productservice.dto.Product;

@Service
public class ProductServiceImpl implements ProductServiceI {
	
	@Override
	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setProductId(id);
		product.setChannel("GET");
		return product;
	}

	@Override
	public Product postProduct(Integer id) {
		Product product = new Product();
		product.setProductId(id);
		product.setChannel("POST");
		return product;
	}

}
