package com.example.springboot.assignment.todolist.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name="assignment_table")
public class TodoItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="task")
    private String title;

    @Column(name="status")
    private boolean status;

//    @OneToMany(fetch = FetchType.EAGER,
//            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
//                    CascadeType.REFRESH})
//    //@JoinTable(joinColumns = @JoinColumn(name = "id") ,name = "user")
//    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
//    private List<User> users;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="user",
            joinColumns=@JoinColumn(name="assignment_id"),
            inverseJoinColumns=@JoinColumn(name="authority_id")
    )
    private List<Authority> authorities;

    public TodoItem(){

    }

    public TodoItem(int id, String title, boolean status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }


}
