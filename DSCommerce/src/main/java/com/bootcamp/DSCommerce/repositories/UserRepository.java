package com.bootcamp.DSCommerce.repositories;

import com.bootcamp.DSCommerce.entities.User;
import com.bootcamp.DSCommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<UserDetailsProjection> searchByUserAndRolesByEmail(String email);
    Optional<User> findByEmail(String email);
}
