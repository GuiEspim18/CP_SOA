package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
