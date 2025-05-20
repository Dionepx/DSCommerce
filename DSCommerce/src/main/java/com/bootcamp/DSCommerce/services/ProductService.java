package com.bootcamp.DSCommerce.services;

import com.bootcamp.DSCommerce.dto.CategoryDTO;
import com.bootcamp.DSCommerce.dto.ProductDTO;
import com.bootcamp.DSCommerce.dto.ProductMinDTO;
import com.bootcamp.DSCommerce.entities.Category;
import com.bootcamp.DSCommerce.entities.Product;
import com.bootcamp.DSCommerce.repositories.ProductRepository;
import com.bootcamp.DSCommerce.services.exceptions.DatabaseException;
import com.bootcamp.DSCommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        Product product = respository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso nao encontrado")
        );
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
        try {
        Product entity = respository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = respository.save(entity);
        return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso nao encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(!respository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso nao encontrado");
        }
        try {
        respository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referecnial");
        }
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
