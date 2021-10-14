package com.kart.springboot.controller;

import com.kart.springboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("create/{userId}")
    public String createCart(Model model, @ModelAttribute("userId") Long userId) throws Exception {

        return "redirect:api/cart" + userId + "/list";
    }

    @PostMapping("/{cartId}/add/product/{productId}/{product}")
    public String addProductToCart(Model model, @PathVariable("id") Long cartId, @ModelAttribute("productId") Long productId) throws Exception {

        cartService.addProduct(productId, cartId);
        model.addAttribute("product", productId);
        return "redirect:/api/cart/list/";
    }

    @PostMapping("/{cartId}/delete/product/{productId}")
    public String deleteProductFromCart(Model model, @PathVariable("id") Long cartId, @PathVariable("productId") Long productId) throws Exception {
        cartService.deleteProduct(productId, cartId);
        model.addAttribute("cartId", cartId);
        return "redirect:/api/cart/list/";
    }
}
