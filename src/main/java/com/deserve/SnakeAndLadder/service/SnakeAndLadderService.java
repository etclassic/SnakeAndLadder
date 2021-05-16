package com.deserve.SnakeAndLadder.service;

import com.deserve.SnakeAndLadder.model.Board;

public class SnakeAndLadderService {

    private Board snakeAndLadderBoard;

    private static final int DEFAULT_BOARD_SIZE = 100; //The board will have 100 cells numbered from 1 to 100.

    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new Board(boardSize); //Story #1 : Basic Board
    }

    public SnakeAndLadderService() {
        this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

}
