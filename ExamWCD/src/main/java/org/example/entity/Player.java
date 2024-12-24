package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    private String name;
    private String fullName;
    private String age;

    @ManyToOne
    @JoinColumn(name = "index_id")
    private Indexer indexer;

    // Getters and Setters
}

