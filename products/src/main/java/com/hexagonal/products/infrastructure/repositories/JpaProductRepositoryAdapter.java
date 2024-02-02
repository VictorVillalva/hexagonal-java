package com.hexagonal.products.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hexagonal.products.domain.models.Product;
import com.hexagonal.products.domain.ports.out.ProductRepositoryPort;
import com.hexagonal.products.infrastructure.entities.ProductEntity;

@Component
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final JpaProductRepository jpaProductRepository;

    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaProductRepository.existsById(id)) {
            jpaProductRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id).map(ProductEntity::toDomainModel);
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = ProductEntity.fromDomainModel(product);
        ProductEntity savedProductEntity = jpaProductRepository.save(productEntity);
        return savedProductEntity.toDomainModel();
    }

    @Override
    public Optional<Product> update(Product product) {
        if (jpaProductRepository.existsById(product.getId())) {
            ProductEntity productEntity = ProductEntity.fromDomainModel(product);
            ProductEntity updatedProductEntity = jpaProductRepository.save(productEntity);
            return Optional.of(updatedProductEntity.toDomainModel());
        }
        return Optional.empty();
    }

}
