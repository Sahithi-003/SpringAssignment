package com.example.springboot.assignment.todolist.service;

import com.example.springboot.assignment.todolist.dao.TodoRepo;
import com.example.springboot.assignment.todolist.dao.UserRepo;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.entity.User;
import com.example.springboot.assignment.todolist.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private UserRepo userRepo;

    private TodoRepo todoRepo;

    @Autowired
    public TodoServiceImpl(TodoRepo theTodoRepo, UserRepo theUserRepo){
        todoRepo=theTodoRepo;
        userRepo=theUserRepo;
    }

    @Override
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    @Override
    public TodoItem findById(int theId) {
        Optional<TodoItem> result = todoRepo.findById(theId);
        TodoItem theTodoitem=null;
        if( result.isPresent()){
            theTodoitem=result.get();
        }
        else {
            throw new ItemNotFoundException("Didn`t find Todo Item id - "+theId);
        }
        return theTodoitem;
    }

    @Override
    public void save(TodoItem theTodoItem) {
        todoRepo.save(theTodoItem);
    }

    @Override
    public void deleteById(int theId) {
        todoRepo.deleteById(theId);
    }

    @Override
    public User findByUserName(String name) {
        return userRepo.findByUserName(name);
    }
}
