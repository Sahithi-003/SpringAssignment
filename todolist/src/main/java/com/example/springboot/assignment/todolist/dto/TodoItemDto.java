package com.example.springboot.assignment.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDto {
    private int id;
    @NotEmpty(message = "Task is required")
    private String title;
    private boolean status;
    public TodoItemDto(String title, boolean status) {
        this.title = title;
        this.status = status;
    }
}
