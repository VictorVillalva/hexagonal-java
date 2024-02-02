package com.hexagonal.products.application.usecases;

import com.hexagonal.products.domain.ports.in.DeleteProductUseCase;
import com.hexagonal.products.domain.ports.out.ProductRepositoryPort;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productRepositoryPort.deleteById(id);
    }
}
