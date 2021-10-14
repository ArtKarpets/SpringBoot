package com.kart.springboot.converter;

import com.kart.springboot.dto.CartDTO;
import com.kart.springboot.model.Cart;

public class CartConverter {
    public static CartDTO cartToDto(Cart cart) {
        CartDTO cartDto = new CartDTO();
        cartDto.setId(cart.getId());
        cartDto.setSum(cart.getSum());
        cartDto.setPurchases(cart.getPurchases());
        cartDto.setProduct(cart.getProduct());

        return cartDto;
    }

    public static Cart convertDtoToCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setSum(cartDTO.getSum());
        cart.setProduct(cartDTO.getProduct());
        cart.setPurchases(cartDTO.getPurchases());

        return cart;
    }
}
