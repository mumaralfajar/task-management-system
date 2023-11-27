package com.example.service;

import com.example.model.Task;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> getTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Optional<Task> updateTask(int id, Task taskDetails) {
        Optional<Task> taskOptional = getTaskById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
        }
        return taskOptional;
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}