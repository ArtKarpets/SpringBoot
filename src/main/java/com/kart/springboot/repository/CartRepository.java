package com.kart.springboot.repository;

import com.kart.springboot.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartById(Long id);
}
