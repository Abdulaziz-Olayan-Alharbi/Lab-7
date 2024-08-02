package com.example.lab_7.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Course {
    @NonNull
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String department;
    @PositiveOrZero
    private int capacity;
}
