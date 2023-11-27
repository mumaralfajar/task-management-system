package com.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskTest {

    @Test
    void testTask() {
        // Arrange
        int id = 1;
        String name = "Test Task";
        String description = "This is a test task";
        String status = "In Progress";

        // Act
        Task task = new Task(id, name, description, status);

        // Assert
        assertEquals(id, task.getId());
        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
        assertEquals(status, task.getStatus());

        // Test toString
        String expectedToString = "Task(id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ")";
        assertEquals(expectedToString, task.toString());

        // Test equals and hashCode
        Task sameTask = new Task(id, name, description, status);
        assertTrue(task.equals(sameTask) && sameTask.equals(task));
        assertEquals(task.hashCode(), sameTask.hashCode());

        // Test not equals
        Task differentTask = new Task(2, "Different Task", "This is a different task", "Completed");
        assertTrue(!task.equals(differentTask) && !differentTask.equals(task));
    }
}
