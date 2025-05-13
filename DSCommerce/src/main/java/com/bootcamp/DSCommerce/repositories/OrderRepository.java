package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
