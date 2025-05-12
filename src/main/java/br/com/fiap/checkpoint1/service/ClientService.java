package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.ClientDTO;
import br.com.fiap.checkpoint1.model.Client;
import br.com.fiap.checkpoint1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAll() {
        return clientRepository.findAll().stream().map(ClientDTO::new).toList();
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public String delete(Long id) {
        clientRepository.deleteById(id);
        return "Cliente deletado!";
    }

    public ClientDTO getOne(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return new ClientDTO(client);
    }

    public ClientDTO update(Client client) {
        Client found = clientRepository.findById(client.getId()).orElse(null);
        found.setName(client.getName());
        found.setEmail(client.getEmail());
        found.setSurname(client.getSurname());
        found.setTelephone(client.getTelephone());
        return new ClientDTO(clientRepository.save(found));
    }

}
