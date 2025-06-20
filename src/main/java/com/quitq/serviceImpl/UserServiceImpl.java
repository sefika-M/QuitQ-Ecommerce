package com.quitq.serviceImpl;

import com.quitq.exception.ResourceNotFoundException;
import com.quitq.model.User;
import com.quitq.repo.UserRepository;
import com.quitq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User register(User user) {
        return userRepo.save(user);
    }

    @Override
    public User loginCustomer(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> users = userRepo.findByNameContainingIgnoreCase(name);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No customers found with name: " + name);
        }
        return users;
    }
    
    
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    
}
