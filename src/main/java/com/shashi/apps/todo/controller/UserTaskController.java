package com.shashi.apps.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.apps.todo.pojo.Task;
import com.shashi.apps.todo.service.TaskService;


@RestController
public class UserTaskController {
    
    @Autowired
    private TaskService service; 

    @GetMapping(value="/users/{user-id}/tasks")
    public ResponseEntity<List<Task>> getUserDetails(@Validated @PathVariable("user-id") Long id) {
        List<Task> taskList = service.getTaskByUserId(id);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @PostMapping(value="/users/{user-id}/tasks")
    public ResponseEntity<Task> createTask(@Validated @RequestBody Task task) {
        Task taskRes = service.save(task);
        return new ResponseEntity<>(taskRes, HttpStatus.OK);
    }
}
