package com.bootcamp.DSCommerce.dto;

import com.bootcamp.DSCommerce.entities.OrderItem;

public class OrderItemDTO {

    private Long productId;
    private String name;
    private Integer quantity;
    private Double price;
    private String imgUrl;

    public OrderItemDTO(Long productId, String name, Integer quantity, Double price, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        quantity = entity.getQuantity();
        price = entity.getProduct().getPrice();
        imgUrl = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
