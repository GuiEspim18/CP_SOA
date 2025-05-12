package br.com.fiap.checkpoint1.dto;

import br.com.fiap.checkpoint1.model.Client;

public record ClientDTO(
        Long id,
        String name,
        String surname,
        String email,
        String telephone
) {
    public ClientDTO(Client client) {
        this(client.getId(), client.getName(), client.getSurname(), client.getEmail(), client.getTelephone());
    }
}