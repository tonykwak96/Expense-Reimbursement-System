package com.example.Project1.Controllers;


import com.example.Project1.Models.User;
import com.example.Project1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Save a user in database
     * @param user
     */
    @PostMapping()
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

    /**
     * View User by given name
     * @param name
     * @return User instance
     */
    @GetMapping("/name/{name}")
    public User viewUserByName(@PathVariable String name){
        return userService.viewUserByName(name);
    }

    /**
     * View User by given id
     * @param id
     * @return User instance
     */
    @GetMapping("/id/{id}")
    public Optional<User> viewUserById(@PathVariable int id){
        return userService.viewUserById(id);
    }

    /**
     * Get all Users in system
     * @return list of users
     */
    @GetMapping("/all")
    public List<User> viewAllUsers(){
        return userService.viewAllUsers();
    }

    /**
     * Delete Test User
     */
    @PutMapping("/delete")
    public void deleteTestUser(){
        userService.deleteTestUsers();
    }


}
