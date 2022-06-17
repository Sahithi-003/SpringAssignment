package com.example.springboot.assignment.todolist;

import com.example.springboot.assignment.todolist.dao.TodoRepo;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.service.TodoServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

public class EntityTests {
    //@Autowired
    //private TodoServiceImpl todoService;

    @MockBean
    private TodoRepo todoRepo;

}
