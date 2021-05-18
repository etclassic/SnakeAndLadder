package com.deserve.SnakeAndLadder.util;

import com.deserve.SnakeAndLadder.model.Board;
import com.deserve.SnakeAndLadder.model.DiceType;
import com.deserve.SnakeAndLadder.model.Snake;
import com.deserve.SnakeAndLadder.model.SnakeType;
import com.deserve.SnakeAndLadder.service.DiceService;

import java.util.List;

public class ProcessorUtil {

    public static int getValueAfterDiceRolls(DiceType diceType) {

        int diceValue = DiceService.roll(diceType);
        System.out.println("Dice rolled, gives value :: " + diceValue);
        return diceValue;
    }

    public static int snakeCheck(int currentPos, List<Snake> snakes) {

        Snake biteSnake = null;
        for (Snake snake: snakes) {
            if(snake.getStart() == currentPos){
                biteSnake = snake;
                System.out.println(snake.getSnakeType() == SnakeType.NORMAL ? "Normal"  : "BiteSnake");
                System.out.println("Snake found at :: " + snake.getStart());
                currentPos = snake.getEnd();
                System.out.println("Sending player to snake's end :: " + snake.getEnd());
                break;
            }
        }

        if(biteSnake != null){
            snakes.remove(biteSnake);
        }
        System.out.println("Snake list size:: " + snakes.size());
        return currentPos;
    }
}
