package com.spring.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.entities.Product;
import com.spring.restapi.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	
	@GetMapping("/{productId}")
	public String getProductById(@PathVariable String productId) {
		return "This product is of Id " + productId;
	}
 }
