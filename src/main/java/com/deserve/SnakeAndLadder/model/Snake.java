package com.deserve.SnakeAndLadder.model;

import lombok.Data;

@Data
public class Snake {
    private int start;
    private int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
