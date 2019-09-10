package com.mytutorials.crudspring.services;

import com.mytutorials.crudspring.entities.Product;
import com.mytutorials.crudspring.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<String> getProductsName() {
        List<String> response = new ArrayList<>();
        List<Product> all = productRepository.findAll();
        for (Product product : all) {
            response.add(product.getName());
        }
        return response;
    }
}
