package com.hexagonal.products.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hexagonal.products.domain.models.Product;
import com.hexagonal.products.domain.ports.in.RetrieveProductUseCase;
import com.hexagonal.products.domain.ports.out.ProductRepositoryPort;

public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public RetrieveProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepositoryPort.findById(id);
    }

}
