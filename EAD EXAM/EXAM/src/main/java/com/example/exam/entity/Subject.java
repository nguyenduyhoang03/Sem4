package com.example.exam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "subject_t")
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    @Column(name = "subject_code", nullable = false)
    private String subjectCode;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    private int credit;
}

