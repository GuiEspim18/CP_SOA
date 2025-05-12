package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.ClientDTO;
import br.com.fiap.checkpoint1.dto.OrderDTO;
import br.com.fiap.checkpoint1.model.Client;
import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderDTO::new).toList();
    }

    public String delete(Long id) {
        orderRepository.deleteById(id);
        return "Pedido deletado!";
    }

    public OrderDTO getOne(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return new OrderDTO(order);
    }

    public OrderDTO update(Order order) {
        Order found = orderRepository.findById(order.getId()).orElse(null);
        found.setDate(order.getDate());
        found.setProducts(order.getProducts());
        found.setClient(order.getClient());
        return new OrderDTO(orderRepository.save(found));
    }

}
