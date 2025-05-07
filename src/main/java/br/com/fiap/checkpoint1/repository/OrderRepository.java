package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
