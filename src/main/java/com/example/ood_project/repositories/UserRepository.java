package com.example.ood_project.repositories;

import java.util.List;

import com.example.ood_project.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
    User findById(long id);
}