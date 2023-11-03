package com.example.ood_project.repositories;

import com.example.ood_project.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
