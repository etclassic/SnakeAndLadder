package com.deserve.SnakeAndLadder.model;

import lombok.Data;

@Data
public class Snake {
    private int start;
    private int end;
    private SnakeType snakeType;

    public Snake(int start, int end, SnakeType snakeType) {
        this.start = start;
        this.end = end;
    }
}
