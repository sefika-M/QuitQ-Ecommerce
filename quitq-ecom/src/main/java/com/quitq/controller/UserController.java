
package com.quitq.controller;

import com.quitq.model.User;
import com.quitq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public User Register(@RequestBody User user) {
        return userService.register(user);
    }
    
    @PostMapping("/user/login")
    public User loginCustomer(@RequestParam String email, @RequestParam String password) {
        return userService.loginCustomer(email, password);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
