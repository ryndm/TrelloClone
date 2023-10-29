package com.example.ood_project.repositories;

import com.example.ood_project.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
