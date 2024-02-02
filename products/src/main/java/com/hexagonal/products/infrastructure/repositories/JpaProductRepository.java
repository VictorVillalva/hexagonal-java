package com.hexagonal.products.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.products.infrastructure.entities.ProductEntity;

@Repository
public interface JpaProductRepository extends JpaRepository <ProductEntity, Long>{
    
}
