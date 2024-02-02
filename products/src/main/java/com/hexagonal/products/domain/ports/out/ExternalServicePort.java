package com.hexagonal.products.domain.ports.out;

import com.hexagonal.products.domain.models.AdditionalProductInfo;

public interface ExternalServicePort {
    AdditionalProductInfo getAdditionalProductInfo(Long productId);
}  

