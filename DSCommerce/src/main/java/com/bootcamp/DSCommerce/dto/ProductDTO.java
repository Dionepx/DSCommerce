package com.bootcamp.DSCommerce.dto;

import com.bootcamp.DSCommerce.entities.Category;
import com.bootcamp.DSCommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 5, max = 10, message = "Minimo de 5 caracteres e maximo de 10")
    private String name;

    @NotBlank(message = "Campo requerido")
    @Size(min = 10, max = 60, message = "Minimo de 10 caracteres e maximo de 60")
    private String description;

    @NotNull(message = "Campo requerido")
    @Positive(message = "Deve ser positivo")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve conter pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for(Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

}
