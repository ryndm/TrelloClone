package com.example.ood_project.models;

import java.util.HashMap;
import java.util.Map;

public class AverageAnalytics extends Analytics {

    public AverageAnalytics(Iterable<Task> tasks) {
        result = new HashMap<>();
        computeAnalytics(tasks);
    }

    @Override
    public void computeAnalytics(Iterable<Task> tasks) {
        Long totalTodoTime = 0L;
        Long totalDoingTime = 0L;
        long size = 0L;

        for(Task task : tasks) {
            totalTodoTime += task.getTimeInToDo();
            totalDoingTime += task.getTimeInDoing();
            size += 1;
        }

        result.put("Average time spent in Todo: ", formatDuration(totalTodoTime/size));
        result.put("Average time spent in Doing", formatDuration(totalDoingTime/size));
    }
}
