package com.deserve.SnakeAndLadder.model;


import lombok.Data;

@Data
public class Board {
    private int size;

    public Board(int size) {
        this.size = size;
    }

}
