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
    public Product createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        return newProduct;
    }

    @DeleteMapping("delete/productId")
    public String delete(@PathVariable Long productId) {
        String delete = productService.deleteProductById(productId);
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

    @GetMapping("/findProductByName/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String productName) {
        return ResponseEntity.ok(productService.findProductByName(productName));
    }

    @GetMapping("/findProductByCost/{cost}")
    public ResponseEntity<Product> findProductByCost(@PathVariable BigDecimal productCost) {
        return ResponseEntity.ok(productService.findProductByCost(productCost));
    }
}
