package com.hexagonal.products.domain.ports.in;

import com.hexagonal.products.domain.models.AdditionalProductInfo;

public interface GetAdditionalProductInfoUseCase {
    AdditionalProductInfo getAdditionalProductInfo(Long productId);
}