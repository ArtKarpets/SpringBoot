package com.kart.springboot.service;

import com.kart.springboot.model.Cart;
import com.kart.springboot.model.Product;
import com.kart.springboot.model.User;
import com.kart.springboot.repository.CartRepository;
import com.kart.springboot.repository.ProductRepository;
import com.kart.springboot.repository.UserRepository;



public class CartServiceImpl implements CartService {

    private UserRepository userRepo;
    private CartRepository cartRepo;
    private ProductRepository productRepo;


    @Override
    public Cart createCart(Long userId) throws Exception {
        if (!userRepo.existsById(userId)) {
            throw new Exception("User does not exist(createCart)");
        }
        Cart cart = cartRepo.save(new Cart());
        User user = userRepo.findUserById(userId);
        user.setCart(cart);
        userRepo.save(user);
        return cart;
    }

    @Override
    public String deleteCartById(Long cartId) throws Exception {
        if (!cartRepo.existsById(cartId)) {
            throw new Exception("Cart does not exist (deleteCartFromId)");
        }
        cartRepo.deleteById(cartId);
        return "Cart " + cartId + " delete successfully";
    }

    @Override
    public Cart addProduct(Long productId, Long cartId) throws Exception {
        if (!cartRepo.existsById(cartId)) {
            throw new Exception("Cart does not exist (addProduct)");
        }
        Cart cart = cartRepo.findCartById(cartId);
        Product product = productRepo.findProductById(productId);
        cart.setSum(cart.getSum().multiply(product.getPrice()));
        cart.setPurchases(cart.getPurchases() + 1);
        cart.getProduct().add(product);
        cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart deleteProduct(Long productId, Long cartId) throws Exception {
        if (cartRepo.existsById(cartId)) {
            throw new Exception("Cart does not exist(deleteProduct)");
        }
        Cart cart = cartRepo.getById(cartId);
        productRepo.deleteById(productId);
        return cart;
    }
}
