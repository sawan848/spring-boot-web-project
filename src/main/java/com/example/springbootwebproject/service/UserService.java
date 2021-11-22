package com.example.springbootwebproject.service;

import com.example.springbootwebproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saawan
 * On 19 Nov, 2021
 * 8:38 PM
 */

public interface UserService {
     List<User> getAllUsers();
     void saveUser(User user);
     User getUserById(long userId);
     void deleteEmployeeId(long id);

}
