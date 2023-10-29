package com.example.ood_project.controllers;

import com.example.ood_project.models.Comment;
import com.example.ood_project.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/comments") // This means URL's start with /comments (after Application path)
public class CommentController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CommentRepository commentRepository;

    @PostMapping(path="") // Map ONLY POST Requests
    public @ResponseBody String addNewTask (@RequestBody Comment comment) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        commentRepository.save(comment);
        return "Saved";
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<Comment> getAllTasks() {
        // This returns a JSON or XML with the tasks
        return commentRepository.findAll();
    }
}