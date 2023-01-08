package com.shashi.apps.todo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shashi.apps.todo.pojo.User;
import com.shashi.apps.todo.service.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    @Autowired
    private UserService service; 
    

    @PostMapping(value="/users")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        User userRes = service.createUser(user);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }

    @GetMapping(value="/users/{user-id}")
    public ResponseEntity<User> getUserDetails(@Validated @PathVariable("user-id") Long id) {
        System.out.println(id);
        User userRes = service.getUserById(id);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }
    
}
