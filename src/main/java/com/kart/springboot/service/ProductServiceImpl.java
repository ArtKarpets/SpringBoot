package com.kart.springboot.service;

import com.kart.springboot.dao.ProductDao;
import com.kart.springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void createProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public String deleteProduct(Product product) {
        productDao.deleteProduct(product);
        return "Product " + product + " delete";
    }

    @Override
    public Product findProductById(Long productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAllProduct();
    }
}
