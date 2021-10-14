package com.kart.springboot.converter;


import com.kart.springboot.dto.UserDTO;
import com.kart.springboot.model.User;

public class UserConverter {

    public static UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setMail(user.getMail());

        return userDTO;
    }

    public static User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setMail(userDTO.getMail());

        return user;
    }
}
