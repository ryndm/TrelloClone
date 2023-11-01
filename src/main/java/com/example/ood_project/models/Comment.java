package com.example.ood_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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
}