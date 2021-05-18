package com.deserve.SnakeAndLadder.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {
    private String name;
    private String id;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.currentPosition = 0;
    }
}

