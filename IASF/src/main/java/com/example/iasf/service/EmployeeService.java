package com.example.iasf.service;

import com.example.iasf.entity.Employee;
import com.example.iasf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Employee> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
