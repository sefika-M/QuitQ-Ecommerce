package com.quitq.service;

import com.quitq.model.User;

import java.util.List;

public interface UserService {

    User register(User user);
    User loginCustomer(String email, String password);
    User getUserById(int id);
    List<User> getUserByName(String name);
    List<User> getAllUsers();

}
