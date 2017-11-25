package com.miage.business.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miage.business.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
