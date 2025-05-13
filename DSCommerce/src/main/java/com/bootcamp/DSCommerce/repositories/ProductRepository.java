package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
