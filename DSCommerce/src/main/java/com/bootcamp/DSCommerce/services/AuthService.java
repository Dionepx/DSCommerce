package com.bootcamp.DSCommerce.services;

import com.bootcamp.DSCommerce.entities.User;
import com.bootcamp.DSCommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId) {
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
