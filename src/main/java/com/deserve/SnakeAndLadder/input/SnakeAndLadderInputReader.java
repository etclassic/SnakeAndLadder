package com.deserve.SnakeAndLadder.input;

import com.deserve.SnakeAndLadder.model.DiceType;
import com.deserve.SnakeAndLadder.model.Snake;

import java.util.List;

public interface SnakeAndLadderInputReader {
	DiceType getDiceType();
	List<Snake>  getSnakes();
}
