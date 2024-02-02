package com.hexagonal.products.domain.ports.in;

public interface DeleteProductUseCase{
    boolean deleteProduct(Long id);
}