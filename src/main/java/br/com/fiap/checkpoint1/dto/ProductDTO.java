package br.com.fiap.checkpoint1.dto;

import br.com.fiap.checkpoint1.model.Product;
import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String name,
        BigDecimal price,
        Integer quantity
) {
    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
    }
}