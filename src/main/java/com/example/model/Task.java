package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int id;
    private String name;
    private String description;
    private String status;
}