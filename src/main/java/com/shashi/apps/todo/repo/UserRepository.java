package com.shashi.apps.todo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashi.apps.todo.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
