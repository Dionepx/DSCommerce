package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Page<Product> searchByName(String name, Pageable pageable);
}
