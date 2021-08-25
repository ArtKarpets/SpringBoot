package com.kart.springboot.repository;

import com.kart.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Long id);

    Product findProductByName(String name);

    Product findProductByPrice(BigDecimal price);
}
