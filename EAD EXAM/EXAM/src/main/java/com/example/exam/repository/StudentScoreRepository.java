package com.example.exam.repository;

import com.example.exam.entity.Student;
import com.example.exam.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
    List<StudentScore> findByStudent(Student student);
}

