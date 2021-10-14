package com.kart.springboot.service;

import com.kart.springboot.dto.UserDTO;
import com.kart.springboot.model.User;
import com.kart.springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void createUpdateUser(User user) {
        log.debug("Add user", user);
        userRepo.save(user);
    }

    @Override
    public String deleteUser(Long id) throws Exception {
        log.debug("Delete user", id);
        userRepo.deleteById(id);
        return "User " + id + " delete ";
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public User findUserById(Long id) {
        log.debug("Find user by id", id);
        return userRepo.findById(id).get();
    }
}
