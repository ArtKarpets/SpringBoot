package com.kart.springboot.dto;

import com.kart.springboot.model.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private BigDecimal sum;
    private int purchases;
    private List<Product> product;

    public CartDTO() {
    }

    public CartDTO(Long id, BigDecimal sum, int purchases, List<Product> product) {
        this.id = id;
        this.sum = sum;
        this.purchases = purchases;
        this.product = product;
    }
}
