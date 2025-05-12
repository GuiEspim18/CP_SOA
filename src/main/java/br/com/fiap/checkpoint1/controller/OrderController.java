package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.ClientDTO;
import br.com.fiap.checkpoint1.dto.OrderDTO;
import br.com.fiap.checkpoint1.model.Client;
import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> get() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.create(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.getOne(id));
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(order));
    }

}
