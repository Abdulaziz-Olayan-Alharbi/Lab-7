package com.example.lab_7.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Student {
    @NonNull
    private int id;
    @NotEmpty
    private String name;
    @NonNull
    private double gpa;
    @NonNull
    @PositiveOrZero
    private int hours;
}
