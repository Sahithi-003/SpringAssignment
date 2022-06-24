package com.example.springboot.assignment.todolist.controller;

import com.example.springboot.assignment.todolist.dto.TodoItemDto;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.entity.User;
import com.example.springboot.assignment.todolist.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/todolist")
public class TodoController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TodoService todoService;

    private String page="todolist/todos";
    public TodoController(TodoService theTodoService) {
        todoService = theTodoService;
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }


    @GetMapping("/success")
    public String showSuccess() {

        return "todolist/success";
    }

    @GetMapping("/list")
    public String listTodoItems(Model theModel) {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String userName=auth.getName();
        User user = todoService.findByUserName(userName);
        List<TodoItem> theTodos=user.getItems();
        theModel.addAttribute("todolist", theTodos);
        return "todolist/list-items";
    }

    // add mapping for "/list"
    @GetMapping("/lists")
    public String listAllTodos(Model theModel) {

        // get employees from db
        List<TodoItem> theTodos = todoService.findAll();

        // add to the spring model
        theModel.addAttribute("todolist", theTodos);

        return "todolist/list-items";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        TodoItem theTodoItem = new TodoItem();

        theModel.addAttribute("item", theTodoItem);

        return page;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("itemId") int theId, Model theModel){
        //get employee from the service
        TodoItem theTodoItem=todoService.findById(theId);

        //set employee as model attribute to prepopulate the form
        theModel.addAttribute("item",theTodoItem);

        //send to our from
        return page;
    }

    @GetMapping("/showFormForUpdateStatus")
    public String showFormForUpdateStatus(@RequestParam("itemId") int theId, Model theModel){
        //get employee from the service
        TodoItem theTodoItem=todoService.findById(theId);

        //set employee as model attribute to prepopulate the form
        theModel.addAttribute("item",theTodoItem);

        //send to our from
        return "status-page";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("item") TodoItemDto theTodoItem, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return page;
        }

        // convert DTO to entity
        TodoItem theItem = modelMapper.map(theTodoItem, TodoItem.class);

        // save the employee
        todoService.save(theItem);

        // use a redirect to prevent duplicate submissions
        return "redirect:/todolist/lists";
    }
    @PostMapping("/savelist")
    public String saveMethod(@Valid @ModelAttribute("item") TodoItemDto theTodoItem, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return page;
        }

        // convert DTO to entity
        TodoItem theItem = modelMapper.map(theTodoItem, TodoItem.class);

        // save the employee
        todoService.save(theItem);

        // use a redirect to prevent duplicate submissions
        return "redirect:/todolist/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId){
        //delete the employee
        todoService.deleteById(theId);

        return "redirect:/todolist/lists";
    }

}
