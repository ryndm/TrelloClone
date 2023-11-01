package com.example.ood_project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
    private String description; // by default null

    @Column(nullable = true)
    private TaskState state; // by default todo

    @Column(nullable = true)
    private LocalDateTime created_at; // by default current time. Should not be given in input

    @ManyToMany(mappedBy = "tasks") // mappedBy points to the "tasks" field in the User class
    private Set<User> users; // by default null or an empty set

    @Column(nullable = true)
    private List<String> comments;

    // Validate all the fields
}

enum TaskState {
    TODO,
    DOING,
    DONE
}
