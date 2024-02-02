package com.hexagonal.products.domain.ports.in;
import com.hexagonal.products.domain.models.Product;
import java.util.Optional;

public interface UpdateProductUseCase{
    Optional <Product> updateProduct(Long id, Product updateProduct);
}