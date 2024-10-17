package com.example.PrevalinkBackend.service;
import java.util.List; 
import java.util.Optional;

import com.example.PrevalinkBackend.model.User; 

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
