package com.example.ood_project.repositories;

import com.example.ood_project.models.Task;
import org.springframework.data.repository.CrudRepository;
import com.example.ood_project.models.*;

import java.util.*;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByTitle(String title);
    List<Task> findByAssignee(String user);
    List<Task> findByState(TaskState state);
}
