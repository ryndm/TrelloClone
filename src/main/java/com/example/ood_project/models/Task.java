package com.example.ood_project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private TaskState state;

    @Column(nullable = true)
    private Date created_at;

    @ManyToMany(mappedBy = "tasks") // mappedBy points to the "tasks" field in the User class
    private Set<User> users;
}

enum TaskState {
    TODO,
    DOING,
    DONE
}
