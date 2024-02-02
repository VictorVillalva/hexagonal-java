package com.hexagonal.products.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.products.infrastructure.entities.ProductEntity;

public interface JpaProductRepository extends JpaRepository <ProductEntity, Long>{
    
}
