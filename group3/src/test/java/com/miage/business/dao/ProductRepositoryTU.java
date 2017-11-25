package com.miage.business.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.business.SpringBusinessConfigTest;
import com.miage.business.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBusinessConfigTest.class}) 
public class ProductRepositoryTU {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryTU.class);
	
	private static final String NAME = "Banane";
	
    @Autowired
    ProductRepository repository;

    @Test
    public void findByName_success() {
    	Product entity = new Product(NAME);
    	entity = repository.save(entity);
    	
    	assertNotNull(entity);
    	assertNotNull(entity.getId());
    	
    	List<Product> entities = (List<Product>) repository.findByName(NAME);
    	assertNotNull(entities);
    	assertEquals(entities.size(), 1);
    	final Product expectedEntity = entities.get(0);
    	assertEquals(expectedEntity.getName(), NAME);
    	
    	LOGGER.info(">>>>> ProductRepository findByName_success OK");
    }
    
    @Test
    public void findByName_notFound() {
    	List<Product> customers = (List<Product>) repository.findByName("No name");
    	assertNotNull(customers);
    	assertEquals(customers.size(), 0);
    	
    	LOGGER.info(">>>>> ProductRepository findByName_notFound OK");
    }

}