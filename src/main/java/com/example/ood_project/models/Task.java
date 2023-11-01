package com.example.ood_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is required.")
    @NotBlank(message = "Title is cannot be blank.")
    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description; // by default null


    @Column(nullable = true)
    private TaskState state = TaskState.TODO; // by default todo

    @CreationTimestamp
    @Column(nullable = true)
    private LocalDateTime created_at; // by default current time. Should not be given in input


    @ManyToMany(mappedBy = "tasks") // mappedBy points to the "tasks" field in the User class
    private Set<User> users; // by default null or an empty set

    @OneToMany
    @Column(nullable = true)
    private List<Comment> comments;

    // Redundant
//    @PrePersist
//    public void prePersist() {
//        created_at = LocalDateTime.now();
//        description=null;
//        state=TaskState.TODO;
//        users=new HashSet<>();
//        comments=new ArrayList<>();
//    }
    // Validate all the fields

    @Override
    public String toString() {
        return getTitle() + " " + getState();
    }
}

