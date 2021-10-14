package com.kart.springboot.service;

import com.kart.springboot.model.Cart;
import com.kart.springboot.model.Product;
import com.kart.springboot.model.User;

import com.kart.springboot.repository.CartRepository;
import com.kart.springboot.repository.ProductRepository;
import com.kart.springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Cart createCart(Long userId) {
        log.debug("Create cart", userId);
        Cart cart = new Cart();
        User user = userRepo.findById(userId).get();
        Cart userCart = cartRepo.save(cart);
        user.setCart(cart);
        userRepo.save(user);
        return userCart;
    }

    @Override
    public Cart addProduct(Long productId, Long cartId) throws Exception {
        log.debug("Add product", productId, cartId);
        Product product = productRepo.findById(productId).get();
        Cart cart = cartRepo.findById(cartId).get();
        cart.setSum(cart.getSum().multiply(product.getPrice()));
        cart.setPurchases(cart.getPurchases() + 1);
        cart.getProduct().add(product);
        return cartRepo.save(cart);
    }

    @Override
    public Cart deleteProduct(Long productId, Long cartId) throws Exception {
        log.debug("Delete product", productId, cartId);
        Product product = productRepo.findById(productId).get();
        Cart cart = cartRepo.findById(cartId).get();
        for (Product p : cart.getProduct()) {
            if (productId.equals(p.getId())) {
                cart.setPurchases(cart.getPurchases() - 1);
                cart.getSum().subtract(product.getPrice());
                cartRepo.save(cart);
            }
        }
        return cart;
    }
}
