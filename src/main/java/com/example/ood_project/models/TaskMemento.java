package com.example.ood_project.models;

public class TaskMemento {
    private Task task;

    public TaskMemento(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
