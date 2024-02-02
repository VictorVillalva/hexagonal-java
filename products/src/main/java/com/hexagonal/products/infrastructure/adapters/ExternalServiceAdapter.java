package com.hexagonal.products.infrastructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexagonal.products.domain.models.AdditionalProductInfo;
import com.hexagonal.products.domain.ports.out.ExternalServicePort;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AdditionalProductInfo getAdditionalProductInfo(Long productId) {
        String apiUrl = "---" + productId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if (todo == null) {
            return null;
        }

        apiUrl = "---" + todo.getProductId(); //Api de ejemplo
        ResponseEntity<JsonPlaceHolderProduct> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderProduct.class);
        JsonPlaceHolderProduct product = userResponse.getBody();

        if (product == null) {
            return null;
        }

        return new AdditionalProductInfo(product.getId(), product.getNombre(), product.getTipo());

    }

    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long productId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

    }

    private static class JsonPlaceHolderProduct {
        private Long id;
        private String nombre;
        private String tipo;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

    }
}
