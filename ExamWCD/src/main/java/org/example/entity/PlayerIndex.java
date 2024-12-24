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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Indexer getIndexer() {
        return indexer;
    }

    public void setIndexer(Indexer indexer) {
        this.indexer = indexer;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

