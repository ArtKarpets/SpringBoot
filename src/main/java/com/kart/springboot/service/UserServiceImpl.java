package com.kart.springboot.service;

import com.kart.springboot.model.User;
import com.kart.springboot.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    @Override
    public User createUser(User user) {
        User newUser = userRepo.save(user);
        return newUser;
    }

    @Override
    public User updateUser(Long id, String name, String surname) throws Exception {
        if (!userRepo.existsById(id)) {
            throw new Exception("User does not exist (UpdateUser)");
        }
        User user = userRepo.findUserById(id);
        user.setName(name);
        user.setSurname(surname);
        return user;
    }

    @Override
    public String deleteUser(Long id) throws Exception {
        if (!userRepo.existsById(id)) {
            throw new Exception("User does not exist(deleteUser)");
        }
        userRepo.deleteById(id);
        return "User delete successfully";
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findUserById(id);
    }
}
