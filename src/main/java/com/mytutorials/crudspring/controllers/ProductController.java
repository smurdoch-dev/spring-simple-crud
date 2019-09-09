package com.mytutorials.crudspring.controllers;

import com.mytutorials.crudspring.entities.Product;
import com.mytutorials.crudspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> findById(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            log.error("Id {} doesnt exist",id);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    ResponseEntity<Product> create(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        if (!productService.findById(id).isPresent()) {
            log.error("Id {} doesnt exist", id);
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteById(@PathVariable Long id){
        if (!productService.findById(id).isPresent()) {
            log.error("Id {} doesnt exist", id);
            ResponseEntity.badRequest().build();
        }

        productService.deleteById(id);

        return ResponseEntity.ok().build();
    }



}
