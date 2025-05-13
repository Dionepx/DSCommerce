package com.bootcamp.DSCommerce.services;

import com.bootcamp.DSCommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository respository;


}
