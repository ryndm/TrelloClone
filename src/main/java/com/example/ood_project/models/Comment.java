package com.example.ood_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Comment cannot be empty.")
    @NotNull(message = "Comment is required.")
    private String val;

    @Column(nullable = false)
    @NotBlank(message = "User cannot be empty.")
    @NotNull(message = "User is required.")
    private String userEmail;

    @CreationTimestamp
    @Column(nullable = true)
    private LocalDateTime created_at; // by default current time. Should not be given in input

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;
}