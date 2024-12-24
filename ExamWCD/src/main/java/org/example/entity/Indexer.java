package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "indexer")
public class Indexer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int indexId;

    private String name;
    private float valueMin;
    private float valueMax;

    // Getters and Setters
}

