package com.everis.bootcamp.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bootcamp.productservice.dto.Product;
import com.everis.bootcamp.productservice.service.ProductServiceI;

@RestController()
@RequestMapping("/producto")
public class ProductController {

	@Autowired
	ProductServiceI productoService;
	@Autowired
	Environment enviroment;

	@GetMapping(value = "/{id}")
	public Product getProduct(@PathVariable Integer id) {
		Product pro = productoService.getProduct(id);
		pro.setPort(enviroment.getProperty("local.server.port"));
		return pro;
	}

	@PostMapping(value = "/{id}")
	public Product postProduct(@PathVariable Integer id) {
		return productoService.postProduct(id);
	}
}
