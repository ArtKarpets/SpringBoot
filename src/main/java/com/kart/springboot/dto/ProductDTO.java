package com.kart.springboot.dto;

import com.kart.springboot.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
