package com.example.exam.controller;


import com.example.exam.entity.Student;
import com.example.exam.entity.StudentScore;
import com.example.exam.service.StudentScoreService;
import com.example.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentScoreService studentScoreService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @PostMapping("/score")
    public ResponseEntity<StudentScore> addScore(@RequestBody StudentScore studentScore) {
        return ResponseEntity.ok(studentScoreService.addScore(studentScore));
    }
}

