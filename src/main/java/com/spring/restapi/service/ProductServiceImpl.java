package com.spring.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.restapi.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	List<Product> productList;

	public ProductServiceImpl() {

		productList = new ArrayList<>();
		productList.add(new Product(1, "OnePlus 9", 49999));
		productList.add(new Product(2, "Iphone 12", 69999));
		productList.add(new Product(3, "Mac Book Pro", 122000));
	}

	@Override
	public List<Product> getAllProduct() {

		return productList;
	}

	@Override
	public Product getProductById(long productId) {

		return null;
	}

}
