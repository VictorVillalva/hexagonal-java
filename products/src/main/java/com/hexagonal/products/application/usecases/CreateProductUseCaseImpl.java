package com.hexagonal.products.application.usecases;

import com.hexagonal.products.domain.models.Product;
import com.hexagonal.products.domain.ports.in.CreateProductUseCase;
import com.hexagonal.products.domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);
    }


}
