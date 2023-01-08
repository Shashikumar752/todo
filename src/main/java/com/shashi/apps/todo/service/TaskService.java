package com.shashi.apps.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.apps.todo.pojo.Task;
import com.shashi.apps.todo.repo.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskrepo;

    public List<Task> getTaskByUserId(Long id) {
        return taskrepo.findByCreatedBy(id);
    }

    public Task save(Task task) {
        return taskrepo.save(task);
    }

}
