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

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Indexer getIndexer() {
        return indexer;
    }

    public void setIndexer(Indexer indexer) {
        this.indexer = indexer;
    }
}

