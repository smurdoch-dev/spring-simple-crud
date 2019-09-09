package com.mytutorials.crudspring.repositories;

import com.mytutorials.crudspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
