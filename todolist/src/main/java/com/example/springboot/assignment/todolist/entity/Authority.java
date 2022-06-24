package com.example.springboot.assignment.todolist.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="authority")
public class Authority {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="role")
    private String role;
    public Authority(){}
    public Authority(String role) {
        this.role = role;
    }
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
}
