package com.example.springboot.assignment.todolist.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="authority")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

//    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name="assignment_id")
//    private TodoItem todoItem;
//
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(inverseJoinColumns = @JoinColumn(name="authority_id"),name = "authority")
//    private Authority authority;


    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
