package com.kart.springboot.repository;

import com.kart.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
