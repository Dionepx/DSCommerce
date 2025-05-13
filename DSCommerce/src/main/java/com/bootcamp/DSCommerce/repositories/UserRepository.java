package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
