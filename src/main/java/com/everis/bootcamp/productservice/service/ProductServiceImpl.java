package com.everis.bootcamp.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.everis.bootcamp.productservice.dto.Product;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	Environment environment;

	@Value("${server.port}")
	private String port;

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
