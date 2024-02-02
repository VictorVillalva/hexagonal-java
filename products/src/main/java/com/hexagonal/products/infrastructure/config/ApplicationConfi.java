package com.hexagonal.products.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.products.application.services.ProductService;
import com.hexagonal.products.application.usecases.CreateProductUseCaseImpl;
import com.hexagonal.products.application.usecases.DeleteProductUseCaseImpl;
import com.hexagonal.products.application.usecases.GetAdditionalProductInfoUseCaseImpl;
import com.hexagonal.products.application.usecases.RetrieveProductUseCaseImpl;
import com.hexagonal.products.application.usecases.UpdateProductUseCaseImpl;
import com.hexagonal.products.domain.ports.in.GetAdditionalProductInfoUseCase;
import com.hexagonal.products.domain.ports.out.ExternalServicePort;
import com.hexagonal.products.domain.ports.out.ProductRepositoryPort;
import com.hexagonal.products.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.products.infrastructure.repositories.JpaProductRepositoryAdapter;

@Configuration
public class ApplicationConfi {

    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort,
            GetAdditionalProductInfoUseCase getAdditionalProductInfoUseCase) {
        return new ProductService(
                new CreateProductUseCaseImpl(productRepositoryPort),
                new RetrieveProductUseCaseImpl(productRepositoryPort),
                new UpdateProductUseCaseImpl(productRepositoryPort),
                new DeleteProductUseCaseImpl(productRepositoryPort),
                getAdditionalProductInfoUseCase);
    }

    @Bean
    public ProductRepositoryPort productRepositoryPort(JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
        return jpaProductRepositoryAdapter;
    }

    @Bean
    public GetAdditionalProductInfoUseCase getAdditionalProductInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalProductInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
