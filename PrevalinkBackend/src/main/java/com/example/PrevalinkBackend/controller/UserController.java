package com.example.PrevalinkBackend.controller;

import com.example.PrevalinkBackend.model.User;
import com.example.PrevalinkBackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import java.util.List; 
import java.util.Optional;


@RestController

@RequestMapping("/api/users")

public class UserController {

    @Autowired 
    private UserService userService;



    @GetMapping 
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    // Gets a user by their user ID 
    @GetMapping("/{id}")

    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Create a new user 

    @PostMapping 

    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    // Update an existing user 
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



   // Delete an existing user
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
       return ResponseEntity.noContent().build();
   }

}