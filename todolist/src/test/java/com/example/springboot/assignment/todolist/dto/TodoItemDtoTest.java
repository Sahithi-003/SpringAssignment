package com.example.springboot.assignment.todolist.dto;

import com.example.springboot.assignment.todolist.entity.TodoItem;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TodoItemDtoTest {
    @Mock
    TodoItemDto item;

    private int id;
    private String title;

    @Test
    void getId() {
        TodoItem item=new TodoItem("Dummy",false);
        Assert.assertEquals(0,item.getId());
    }

    @Test
    void getTitle() {
        TodoItem item=new TodoItem("Dummy",false);
        Assert.assertEquals("Dummy",item.getTitle());
    }

    @Test
    void isStatus() {
        TodoItem item=new TodoItem("Dummy",false);
        Assert.assertEquals(false,item.isStatus());

    }

    @Test
    void setId() {
        TodoItem item=new TodoItem("Dummy",false);
        item.setId(1);
        Assert.assertEquals(1,item.getId());

    }

    @Test
    void setTitle() {
        TodoItem item=new TodoItem("Dummy",false);
        item.setTitle("Dummy");
        Assert.assertEquals("Dummy",item.getTitle());
    }

    @Test
    void setStatus() {
        TodoItem item=new TodoItem("Dummy",false);
        item.setStatus(false);
        Assert.assertEquals(false,item.isStatus());

    }
}