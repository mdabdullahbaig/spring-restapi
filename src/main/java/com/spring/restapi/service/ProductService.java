package com.spring.restapi.service;

import java.util.List;

import com.spring.restapi.entities.Product;

public interface ProductService {
	public List<Product> getAllProduct();

	public Product getProductById(long productId);
}
