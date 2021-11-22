package com.example.springbootwebproject.controller;

import com.example.springbootwebproject.entity.User;
import com.example.springbootwebproject.exception.ResourceNotFoundException;
import com.example.springbootwebproject.repository.UserRepository;
import com.example.springbootwebproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Saawan
 * On 19 Nov, 2021
 * 6:46 PM
 */

@Controller
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("listUser",userService.getAllUsers());
        return "index";
    }
    @GetMapping("/showNewUsersForm")
    public String showNewUsersForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "new_employee";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user")User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")long userId,Model model){
        User userById = userService.getUserById(userId);
        model.addAttribute("user",userById);
        return "update_employee";
    }
    @GetMapping("/deleteUsers/{id}")
    public String deleteUsers(@PathVariable(value = "id")long id){
        userService.deleteEmployeeId(id);
        return "redirect:/";
    }
    /*
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

    }*/
}
