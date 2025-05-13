package com.bootcamp.DSCommerce.services;

import com.bootcamp.DSCommerce.dto.CategoryDTO;
import com.bootcamp.DSCommerce.dto.ProductDTO;
import com.bootcamp.DSCommerce.dto.ProductMinDTO;
import com.bootcamp.DSCommerce.entities.Category;
import com.bootcamp.DSCommerce.entities.Product;
import com.bootcamp.DSCommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
public class ProductService {

    @Autowired
    private ProductRepository respository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = respository.findById(id).orElseThrow();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
        Page<Product> result = respository.searchByName(name, pageable);
        return result.map(x -> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = respository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product entity = respository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = respository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        respository.deleteById(id);
    }

    public void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity.getCategories().clear();
        for(CategoryDTO catDto : dto.getCategories()) {
            Category cat = new Category();
            cat.setId(cat.getId());
            entity.getCategories().add(cat);
        }
    }
}
