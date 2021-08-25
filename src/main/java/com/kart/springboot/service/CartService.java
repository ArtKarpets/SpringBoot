package com.kart.springboot.service;

import com.kart.springboot.model.Cart;


public interface CartService {

    Cart createCart(Long userId) throws Exception;

    String deleteCartById(Long cartId) throws Exception;

    Cart addProduct(Long productId, Long cartId) throws Exception;

    Cart deleteProduct(Long productId, Long cartId) throws Exception;

}
