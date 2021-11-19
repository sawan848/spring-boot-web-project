package com.example.springbootwebproject.controller;

import com.example.springbootwebproject.entity.User;
import com.example.springbootwebproject.exception.ResourceNotFoundException;
import com.example.springbootwebproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Saawan
 * On 19 Nov, 2021
 * 6:46 PM
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get all users
    @GetMapping("/all")
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }

    //get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id")long userId){
        return userRepository.
                findById(userId).
                orElseThrow(()->new ResourceNotFoundException("user not find with id "+userId));
    }

    //create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,
                           @PathVariable("id")long userId){
        User existingUser = userRepository.
                findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("user not find with id " + userId));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<User>deleteUser(@PathVariable("id")long userId){
        User existingUser = userRepository.
                findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("user not find with id " + userId));

        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();

    }
}
