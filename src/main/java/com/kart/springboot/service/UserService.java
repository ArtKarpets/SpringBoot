package com.kart.springboot.service;

import com.kart.springboot.dto.UserDTO;
import com.kart.springboot.model.User;

import java.util.List;

public interface UserService {
    void createUpdateUser(User user);

    String deleteUser(Long id) throws Exception;

    List<UserDTO> getAll();

    User findUserById(Long id);
}
