package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.OrderDTO;
import br.com.fiap.checkpoint1.dto.ProductDTO;
import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.model.Product;
import br.com.fiap.checkpoint1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(ProductDTO::new).toList();
    }

    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Produto deletado!";
    }

    public ProductDTO getOne(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return new ProductDTO(product);
    }

    public ProductDTO update(Product product) {
        Product found = productRepository.findById(product.getId()).orElse(null);
        found.setName(product.getName());
        found.setPrice(product.getPrice());
        found.setQuantity(product.getQuantity());
        return new ProductDTO(productRepository.save(found));
    }

}
