package com.kart.springboot.service;


import com.kart.springboot.dto.ProductDTO;
import com.kart.springboot.model.Product;
import com.kart.springboot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kart.springboot.converter.ProductConverter.productToDto;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;

    @Override
    public ProductDTO createProduct(Product product) {
        log.debug("Create product", product);
        return productToDto(productRepo.save(product));
    }

    @Override
    public String deleteProduct(Long id) {
        log.debug("Delete product", id);
        productRepo.deleteById(id);
        return "Product " + id + " delete";
    }

    @Override
    public ProductDTO findProductById(Long productId) {
        log.debug("Find product by id", productId);
        return productToDto(productRepo.findById(productId).get());
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
