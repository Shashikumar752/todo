package com.shashi.apps.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.apps.todo.pojo.User;
import com.shashi.apps.todo.repo.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo; 

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(Long createdBy) {
        Optional<User> user = userRepo.findById(createdBy);
        return user.isPresent() ? user.get() : null;
    }
}
