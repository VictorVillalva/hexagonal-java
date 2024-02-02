package com.hexagonal.products.application.usecases;

import java.util.Optional;

import com.hexagonal.products.domain.models.Product;
import com.hexagonal.products.domain.ports.in.UpdateProductUseCase;
import com.hexagonal.products.domain.ports.out.ProductRepositoryPort;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product updateProduct) {
        return productRepositoryPort.update(updateProduct);
    }

}
