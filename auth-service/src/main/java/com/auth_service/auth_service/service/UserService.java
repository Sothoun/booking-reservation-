package com.auth_service.auth_service.service;

import com.auth_service.auth_service.model.User;
import com.auth_service.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAllByStatus("Active");
    }

    public User createUser(User user) {
        user.setCreatedAt(new Date());
        user.setId(UUID.randomUUID().toString());
        user.setStatus("Active");
        userRepository.save(user);
        return user;
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }
}
