package com.kart.springboot.dto;

import com.kart.springboot.model.Cart;
import com.kart.springboot.model.User;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private Cart cart;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.cart = cart;
    }


}
