package com.example.service;

import com.example.model.Task;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskServiceTest {

    private TaskService taskService = new TaskService();

    @Test
    void testCreateAndGetAllTasks() {
        // Arrange
        Task task = new Task(1, "Test Task", "This is a test task", "In Progress");

        // Act
        taskService.createTask(task);
        List<Task> tasks = taskService.getAllTasks();

        // Assert
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    void testGetTaskById() {
        // Arrange
        Task task = new Task(1, "Test Task", "This is a test task", "In Progress");
        taskService.createTask(task);

        // Act
        Optional<Task> optionalTask = taskService.getTaskById(1);

        // Assert
        assertTrue(optionalTask.isPresent());
        assertEquals(task, optionalTask.get());
    }

    @Test
    void testUpdateTask() {
        // Arrange
        Task task = new Task(1, "Test Task", "This is a test task", "In Progress");
        taskService.createTask(task);
        Task updatedTask = new Task(1, "Updated Task", "This is an updated task", "Completed");

        // Act
        Optional<Task> optionalTask = taskService.updateTask(1, updatedTask);

        // Assert
        assertTrue(optionalTask.isPresent());
        assertEquals(updatedTask.getName(), optionalTask.get().getName());
        assertEquals(updatedTask.getDescription(), optionalTask.get().getDescription());
        assertEquals(updatedTask.getStatus(), optionalTask.get().getStatus());
    }

    @Test
    void testDeleteTask() {
        // Arrange
        Task task = new Task(1, "Test Task", "This is a test task", "In Progress");
        taskService.createTask(task);

        // Act
        taskService.deleteTask(1);
        Optional<Task> optionalTask = taskService.getTaskById(1);

        // Assert
        assertTrue(optionalTask.isEmpty());
    }
}
