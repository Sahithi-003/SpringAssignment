package com.example.springboot.assignment.todolist.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="assignment_table")
public class TodoItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message = "Task is mandatory")
    @Column(name="task")
    private String title;

    @Column(name="status")
    private boolean status;

    public TodoItem(String title, boolean status) {
        this.title = title;
        this.status = status;
    }
}
