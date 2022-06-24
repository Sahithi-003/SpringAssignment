package com.example.springboot.assignment.todolist.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class AuthorityTest {
    @Mock
    Authority authority;

    @Test
    void getId() {
        Authority authority=new Authority("user");
        Assert.assertEquals(0,authority.getId());
    }

    @Test
    void getRole() {
        Authority authority=new Authority("user");
        Assert.assertEquals("user",authority.getRole());
    }

    @Test
    void getUser() {
        Authority authority=new Authority("user");
        User user=new User("dummy","dummy");
        authority.setUser(user);
        Assert.assertEquals(user,authority.getUser());
    }

    @Test
    void setId() {
        Authority authority=new Authority("user");
        authority.setId(1);
        Assert.assertEquals(1,authority.getId());
    }

    @Test
    void setRole() {
        Authority authority=new Authority("user");
        authority.setRole("user");
        Assert.assertEquals("user",authority.getRole());
    }

    @Test
    void setUser() {
        Authority authority=new Authority("user");
        authority.setId(1);
        Assert.assertEquals(1,authority.getId());
    }
}