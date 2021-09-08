package com.kart.springboot.controller;

import com.kart.springboot.model.Product;
import com.kart.springboot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("delete/productId")
    public String delete(@PathVariable Product product) {
        String delete = productService.deleteProduct(product);
        return delete;
    }

    @GetMapping("get")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/findProductById/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }
}
