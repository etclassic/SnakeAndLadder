package com.deserve.SnakeAndLadder.model;


import com.deserve.SnakeAndLadder.util.Constants;
import lombok.Data;

import java.util.List;

@Data
public class Board {

    private int size =  Constants.DEFAULT_BOARD_SIZE;
    private DiceType diceType;
    private List<Snake> snakes;

    public Board(DiceType diceType, List<Snake> snakes) {
        this.diceType = diceType;
        this.snakes = snakes;
    }

}
