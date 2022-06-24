package com.example.springboot.assignment.todolist.dao;

import com.example.springboot.assignment.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where username = :userName",nativeQuery = true)
    public User findByUserName(String userName);
}
