package com.example.exam.dto;

import com.example.exam.entity.StudentScore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class studentResDTO {
    private int studentId;

    private String studentCode;

    private String fullName;

    private String address;

    private List<StudentScore> scores;
}
