package com.example.iasf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Position is required")
    private String position;

    @Email(message = "Email is invalid")
    private String email;

    @Min(value = 0, message = "Salary must be positive")
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Position is required") String getPosition() {
        return position;
    }

    public void setPosition(@NotBlank(message = "Position is required") String position) {
        this.position = position;
    }

    public @Email(message = "Email is invalid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email is invalid") String email) {
        this.email = email;
    }

    @Min(value = 0, message = "Salary must be positive")
    public double getSalary() {
        return salary;
    }

    public void setSalary(@Min(value = 0, message = "Salary must be positive") double salary) {
        this.salary = salary;
    }
}
