package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
