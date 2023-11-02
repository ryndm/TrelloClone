package com.example.ood_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @NotNull(message = "Email is required.")
    @NotBlank(message = "Email cannot be blank.")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Username is required.")
    @NotBlank(message = "Username cannot be blank.")
    @Column(nullable = false)
    private String username;

    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password cannot be blank.")
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "task_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    @JsonIgnore
    private Set<Task> tasks;

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
