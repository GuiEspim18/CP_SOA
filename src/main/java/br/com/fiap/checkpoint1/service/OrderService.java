package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.model.Product;
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

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

}
