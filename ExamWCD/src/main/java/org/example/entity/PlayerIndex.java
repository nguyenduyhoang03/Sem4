package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_index")
public class PlayerIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "index_id")
    private Indexer indexer;

    private float value;

    // Getters and Setters
}

