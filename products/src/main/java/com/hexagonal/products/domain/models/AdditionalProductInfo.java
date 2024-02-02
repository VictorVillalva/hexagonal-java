package com.hexagonal.products.domain.models;

public class AdditionalProductInfo {
    private final Long productId;
    private final String productNombre;
    private final String productTipo;

    public AdditionalProductInfo(Long productId, String productNombre, String productTipo) {
        this.productId = productId;
        this.productNombre = productNombre;
        this.productTipo = productTipo;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductNombre() {
        return productNombre;
    }

    public String getProductTipo() {
        return productTipo;
    }
}