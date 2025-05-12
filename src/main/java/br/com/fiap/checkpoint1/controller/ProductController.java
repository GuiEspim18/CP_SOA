package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.OrderDTO;
import br.com.fiap.checkpoint1.dto.ProductDTO;
import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.model.Product;
import br.com.fiap.checkpoint1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getOne(id));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

}
