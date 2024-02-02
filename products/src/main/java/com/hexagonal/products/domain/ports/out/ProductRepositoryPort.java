package com.hexagonal.products.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.hexagonal.products.domain.models.Product;

//CRUD
public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List <Product> findAll();
    Optional <Product> update(Product product);
    boolean deleteById(Long id);
}
