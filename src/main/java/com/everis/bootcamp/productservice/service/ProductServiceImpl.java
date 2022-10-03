package com.everis.bootcamp.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bootcamp.productservice.dto.Product;
import org.springframework.core.env.Environment;

@Service
public class ProductServiceImpl implements ProductServiceI {
	
	@Autowired
	Environment environment;
	
	@Override
	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setProductId(id);
		product.setChannel("GET");
		product.setPort(environment.getProperty("local.server.port"));
		return product;
	}

	@Override
	public Product postProduct(Integer id) {
		Product product = new Product();
		product.setProductId(id);
		product.setChannel("POST");
		product.setPort(environment.getProperty("local.server.port"));
		return product;
	}

}
