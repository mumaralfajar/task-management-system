package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    private TaskService taskService = mock(TaskService.class);
    private TaskController taskController = new TaskController(taskService);

    @Test
    void testGetAllTasks() {
        // Arrange
        Task task = new Task(1, "Test Task", "This is a test task", "In Progress");
        when(taskService.getAllTasks()).thenReturn(Arrays.asList(task));

        // Act
        ResponseEntity<List<Task>> response = taskController.getAllTasks();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(task, response.getBody().get(0));
    }

    // Add similar tests for getTaskById, createTask, updateTask, and deleteTask
}
