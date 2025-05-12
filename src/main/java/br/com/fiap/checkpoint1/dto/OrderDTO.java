package br.com.fiap.checkpoint1.dto;

import br.com.fiap.checkpoint1.model.Order;
import java.util.Date;
import java.util.List;

public record OrderDTO(
        Long id,
        Date date,
        ClientDTO client,
        List<ProductDTO> products
) {
    public OrderDTO(Order order) {
        this(order.getId(), order.getDate(), new ClientDTO(order.getClient()),
                order.getProducts().stream().map(ProductDTO::new).toList());
    }
}