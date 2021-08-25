package com.kart.springboot.service;

import com.kart.springboot.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, String name, String surname) throws Exception;

    String deleteUser(Long id) throws Exception;

    List<User> getAll();

    User findUserById(Long id);
}
