package com.example.ood_project.controllers;

import com.example.ood_project.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.ood_project.repositories.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/users") // This means URL's start with /users (after Application path)
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;


    @PostMapping(path="") // Map ONLY POST Requests
    public @ResponseBody User addNewUser (@Valid @RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return userRepository.save(user);
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}