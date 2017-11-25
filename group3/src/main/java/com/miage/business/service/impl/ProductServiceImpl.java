package com.miage.business.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miage.business.dao.ProductRepository;
import com.miage.business.entity.Product;
import com.miage.business.service.ProductService;
import com.miage.utils.ConvertUtils;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product entity) {
		LOGGER.info("ProductService save");
		return productRepository.save(entity);
	}
	
	@Override
	public void deleteById(Long id) {
		LOGGER.info("ProductService deleteById");
		productRepository.deleteById(id);
	}
	
	@Override
	public List<Product> findAll() {
		LOGGER.info("ProductService findAll");
		return productRepository.findAll();
	}
	
	@Override
	public Product findById(Long id) {
		LOGGER.info("ProductService findById");
		return ConvertUtils.convertFromOptional(productRepository.findById(id));
	}

}
