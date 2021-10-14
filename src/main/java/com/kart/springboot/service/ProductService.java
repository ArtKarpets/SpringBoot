package com.kart.springboot.service;

import com.kart.springboot.dto.ProductDTO;
import com.kart.springboot.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductDTO createProduct(Product product);

    String deleteProduct(Long id);

    ProductDTO findProductById(Long productId);

    List<ProductDTO> getAll();
}
