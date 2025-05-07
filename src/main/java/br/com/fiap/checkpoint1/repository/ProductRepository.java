package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
