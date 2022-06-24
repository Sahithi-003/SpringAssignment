package com.example.springboot.assignment.todolist.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class UserTest {
    @Mock
    User user;

    @Test
    void getId() {
        User user= new User("dummy", "abc");
        Assert.assertEquals(0,user.getId());

    }

    @Test
    void getUsername() {
        User user= new User("dummy", "abc");
        Assert.assertEquals("dummy",user.getUsername());

    }

    @Test
    void getPassword() {
        User user= new User("dummy", "abc");
        Assert.assertEquals("abc",user.getPassword());

    }



    @Test
    void setId() {
        User user= new User("dummy", "abc");
        user.setId(1);
        Assert.assertEquals(1,user.getId());

    }

    @Test
    void setUsername() {
        User user= new User("dummy", "abc");
        user.setUsername("dummy");
        Assert.assertEquals("dummy",user.getUsername());

    }

    @Test
    void setPassword() {
        User user= new User("dummy", "abc");
        user.setPassword("abc");
        Assert.assertEquals("abc",user.getPassword());
    }

}