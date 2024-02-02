package com.hexagonal.products.application.usecases;

import com.hexagonal.products.domain.models.AdditionalProductInfo;
import com.hexagonal.products.domain.ports.in.GetAdditionalProductInfoUseCase;
import com.hexagonal.products.domain.ports.out.ExternalServicePort;

public class GetAdditionalProductInfoUseCaseImpl implements GetAdditionalProductInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalProductInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalProductInfo getAdditionalProductInfo(Long productId) {
        return externalServicePort.getAdditionalProductInfo(productId);
    }

}
