package com.example.springboot.assignment.todolist.entity;

public class TodoItemDto {
    private int id;
    private String title;
    private boolean done;

    public TodoItemDto(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItemDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done=" + done +
                '}';
    }

    public TodoItemDto(int id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }
}
