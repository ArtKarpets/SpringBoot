package com.kart.springboot.service;

import com.kart.springboot.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product findProductById(Long productId);

    List<Product> getAll();

    Product createProduct(Product product);

    String deleteProductById(Long productId);

    Product findProductByName(String productName);

    Product findProductByCost(BigDecimal productCost);
}
