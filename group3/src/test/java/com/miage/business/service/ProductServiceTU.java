package com.miage.business.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.miage.business.dao.ProductRepository;
import com.miage.business.entity.Product;
import com.miage.business.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTU {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceTU.class);

	private static final String NAME = "Banane";
	
	@InjectMocks
    ProductService service = new ProductServiceImpl();

    @Mock
    ProductRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_success() {
        
    	// Mock du repository
    	final List<Product> allProducts = Arrays.asList(new Product(NAME));
        Mockito.when(mockRepository.findAll()).thenReturn(allProducts);

        // Test du service
        final List<Product> expectedEntities = service.findAll();
        
        assertNotNull(expectedEntities);
        assertEquals(expectedEntities.size(), 1);
        
        final Product expectedEntity = expectedEntities.get(0);
        assertEquals(expectedEntity.getName(), NAME);
        
        LOGGER.info(">>>>> ProductService findAll_success OK");
    }
	
}
