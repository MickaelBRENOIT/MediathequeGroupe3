package com.miage.business.service;

import java.util.List;

import com.miage.business.entity.Product;

public interface ProductService {
	Product save(Product entity);
	void deleteById(Long id);
	List<Product> findAll();
	Product findById(Long id);
}