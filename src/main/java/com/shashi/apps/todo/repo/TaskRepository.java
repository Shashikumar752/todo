package com.shashi.apps.todo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shashi.apps.todo.pojo.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByCreatedBy(@Param("createdBy") Long createdBy);
}
