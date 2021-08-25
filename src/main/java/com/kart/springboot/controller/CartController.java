package com.kart.springboot.controller;

import com.kart.springboot.model.Cart;
import com.kart.springboot.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
public class CartController {
    CartService cartService;

    @PostMapping("create/{userId}")
    public ResponseEntity<Cart> createCart(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(cartService.createCart(userId));
    }

    @DeleteMapping("/delete/{cartId}")
    public String deleteCart(@PathVariable Long cartId) throws Exception {
        String deleteCart = cartService.deleteCartById(cartId);
        return deleteCart;
    }

    @PutMapping("/{cartId}/add/product/{productId}/{product}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) throws Exception {
        return ResponseEntity.ok(cartService.addProduct(productId, cartId));
    }

    @DeleteMapping("/{cartId}/delete/product/{productId}")
    public ResponseEntity<Cart> deleteProductToCart(@PathVariable Long cartId, @PathVariable Long productId) throws Exception {
        return ResponseEntity.ok(cartService.deleteProduct(productId, cartId));
    }
}
