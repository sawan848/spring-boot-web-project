package com.example.springbootwebproject.service;

import com.example.springbootwebproject.entity.User;
import com.example.springbootwebproject.exception.ResourceNotFoundException;
import com.example.springbootwebproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Saawan
 * On 19 Nov, 2021
 * 8:41 PM
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(long userId) {
        Optional<User> userById = userRepository.findById(userId);
        User user=null;
        if ( userById.isPresent() ){
            user=userById.get();
        }else{
            throw  new ResourceNotFoundException("user not found by id"+userId);
        }
        return user;
    }

    @Override
    public void deleteEmployeeId(long id) {
        this.userRepository.deleteById(id);
    }
}
