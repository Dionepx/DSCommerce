package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
