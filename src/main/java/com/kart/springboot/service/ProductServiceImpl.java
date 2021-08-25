package com.kart.springboot.service;

import com.kart.springboot.model.Product;
import com.kart.springboot.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    @Override
    public Product findProductById(Long productId) {
        Product product = productRepo.findProductById(productId);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Product newProduct = productRepo.save(product);
        return newProduct;
    }

    @Override
    public String deleteProductById(Long productId) {
        productRepo.deleteById(productId);
        return "product delete successfully";
    }

    @Override
    public Product findProductByName(String productName) {
        return productRepo.findProductByName(productName);
    }

    @Override
    public Product findProductByCost(BigDecimal productCost) {
        return productRepo.findProductByPrice(productCost);
    }
}
