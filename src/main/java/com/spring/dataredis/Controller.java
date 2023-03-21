package com.spring.dataredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/product")
    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable int id){
        return productRepository.findById(id);
    }

    @DeleteMapping("/product/{id}")
    String deleteProduct(@PathVariable int id) {
        return productRepository.deleteProduct(id);
    }
}
