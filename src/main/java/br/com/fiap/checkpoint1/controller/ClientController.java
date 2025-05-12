package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.ClientDTO;
import br.com.fiap.checkpoint1.model.Client;
import br.com.fiap.checkpoint1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        System.out.println(client.getName());
        return ResponseEntity.ok(clientService.create(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.getOne(id));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.update(client));
    }

}
