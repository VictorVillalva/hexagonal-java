package com.hexagonal.products.domain.ports.in;

import java.util.List;
import java.util.Optional;
import com.hexagonal.products.domain.models.Product;

public interface RetrieveProductUseCase {
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
}
