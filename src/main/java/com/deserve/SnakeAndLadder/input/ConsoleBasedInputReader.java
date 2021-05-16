package com.deserve.SnakeAndLadder.input;

import com.deserve.SnakeAndLadder.model.DiceType;
import com.deserve.SnakeAndLadder.model.Snake;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleBasedInputReader implements SnakeAndLadderInputReader {
	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public DiceType getDiceType() {
		System.out.println("Select Dice Type:");
		System.out.println("1. Normal Type");
		System.out.println("2. Crooked Type");

		throwExceptionForInvalidValue();
		int diceType = Integer.parseInt(SCANNER.nextLine());

		if (diceType == DiceType.NORMAL_DICE.ordinal()){
			return DiceType.NORMAL_DICE;
		}
		return DiceType.CROOKED_DICE;
	}

	@Override
	public List<Snake> getSnakes() {
		System.out.println("Number of Snakes:");

		throwExceptionForInvalidValue();
		int snakeCount = Integer.parseInt(SCANNER.nextLine());

		return fillSnakesCoordinates(snakeCount);
	}

	private List<Snake> fillSnakesCoordinates(int snakeCount) {

		List<Snake> snakes = new ArrayList<>();
		for (int i=1; i<=snakeCount; i++){
			System.out.println("Snake :: " + i);

			System.out.print("Start: ");
			throwExceptionForInvalidValue();
			int start = Integer.parseInt(SCANNER.nextLine());

			System.out.print("End: ");
			throwExceptionForInvalidValue();
			int end = Integer.parseInt(SCANNER.nextLine());

			// Add ->  start position > end position
			Snake snake = new Snake(start, end);
			snakes.add(snake);
		}

		return snakes;
	}


	private static void throwExceptionForInvalidValue() {
		while (!SCANNER.hasNextInt()) {
			System.err.println("Invalid Value");
			SCANNER.nextLine();
		}
	}

}
