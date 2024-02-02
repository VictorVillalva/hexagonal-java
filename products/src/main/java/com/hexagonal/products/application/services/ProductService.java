package com.hexagonal.products.application.services;

import java.util.List;
import java.util.Optional;

import com.hexagonal.products.domain.models.AdditionalProductInfo;
import com.hexagonal.products.domain.models.Product;
import com.hexagonal.products.domain.ports.in.CreateProductUseCase;
import com.hexagonal.products.domain.ports.in.DeleteProductUseCase;
import com.hexagonal.products.domain.ports.in.GetAdditionalProductInfoUseCase;
import com.hexagonal.products.domain.ports.in.RetrieveProductUseCase;
import com.hexagonal.products.domain.ports.in.UpdateProductUseCase;

public class ProductService implements CreateProductUseCase, RetrieveProductUseCase, UpdateProductUseCase,
        DeleteProductUseCase, GetAdditionalProductInfoUseCase {

    private final CreateProductUseCase createProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final GetAdditionalProductInfoUseCase getAdditionalProductInfoUseCase;

    public ProductService(CreateProductUseCase createProductUseCase, RetrieveProductUseCase retrieveProductUseCase,
            UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase,
            GetAdditionalProductInfoUseCase getAdditionalProductInfoUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.getAdditionalProductInfoUseCase = getAdditionalProductInfoUseCase;
    }

    @Override
    public Product createProduct(Product product) {
        return createProductUseCase.createProduct(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return retrieveProductUseCase.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return retrieveProductUseCase.getAllProducts();
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product updateProduct) {
        return updateProductUseCase.updateProduct(id, updateProduct);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return deleteProductUseCase.deleteProduct(id);
    }

    @Override
    public AdditionalProductInfo getAdditionalProductInfo(Long productId) {
        return getAdditionalProductInfoUseCase.getAdditionalProductInfo(productId);
    }

}
