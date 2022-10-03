package com.everis.bootcamp.productservice.dto;

import org.springframework.beans.factory.annotation.Value;

public class Product {
	private Integer productId;
	private String channel;
	@Value("${local.server.port}")
	private String port;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
}
