package com.example.springboot.assignment.todolist.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="authority")
public class Authority {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="role")
    private String role;

    //@OneToMany(mappedBy = "authority",
            //cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
//    @OneToMany(
//            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
//                    CascadeType.REFRESH})
//    @JoinTable(joinColumns = @JoinColumn(name = "id") ,name = "user")
//    @JoinColumn(name = "authority_id", referencedColumnName = "id")
//    private List<User> users;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="user",
            joinColumns=@JoinColumn(name="authority_id"),
            inverseJoinColumns=@JoinColumn(name="assignment_id")
    )
    private List<TodoItem> items;

    public Authority(){}

    public Authority(int id, String role) {
        this.id = id;
        this.role = role;
    }

}
