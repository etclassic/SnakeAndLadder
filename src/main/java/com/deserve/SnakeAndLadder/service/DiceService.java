package com.deserve.SnakeAndLadder.service;

import com.deserve.SnakeAndLadder.model.DiceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceService {
    public static int roll(DiceType diceType) {

        if(diceType == DiceType.CROOKED_DICE){
            List<Integer> evenNumbers = new ArrayList<>();
            evenNumbers.add(2);
            evenNumbers.add(4);
            evenNumbers.add(6);
            return evenNumbers.get(new Random().nextInt(evenNumbers.size()));
        }
            return new Random().nextInt(6) + 1;

    }
}
