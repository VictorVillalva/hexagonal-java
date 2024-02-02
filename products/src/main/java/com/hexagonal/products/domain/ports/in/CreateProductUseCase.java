package com.hexagonal.products.domain.ports.in;
import com.hexagonal.products.domain.models.Product;

public interface CreateProductUseCase{
    Product createProduct(Product product);
}