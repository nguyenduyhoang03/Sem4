package com.example.exam.service;

import com.example.exam.entity.StudentScore;
import com.example.exam.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreRepository studentScoreRepository;

    public StudentScore addScore(StudentScore studentScore) {
        return studentScoreRepository.save(studentScore);
    }
}
