package com.example.bookstore.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Userss{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String name,firstName, middleName, lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roleList; //user_roleList

    private boolean active = true;

}
