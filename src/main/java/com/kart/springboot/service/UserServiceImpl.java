package com.kart.springboot.service;

import com.kart.springboot.dao.UserDao;
import com.kart.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User updateUser(Long id, String name, String surname) throws Exception {
        User user = userDao.getUserById(id);
        user.setName(name);
        user.setSurname(surname);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public String deleteUser(User user) throws Exception {
        userDao.deleteUser(user);
        return "User " + user + " delete ";
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User findUserById(Long id) {
        return userDao.getUserById(id);
    }
}
