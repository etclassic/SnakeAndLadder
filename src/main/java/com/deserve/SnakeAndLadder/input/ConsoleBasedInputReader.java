package com.deserve.SnakeAndLadder.input;

import com.deserve.SnakeAndLadder.model.DiceType;
import com.deserve.SnakeAndLadder.model.Snake;
import com.deserve.SnakeAndLadder.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleBasedInputReader implements SnakeAndLadderInputReader {
	private static final Scanner SCANNER = new Scanner(System.in);

	private static boolean throwExceptionForInvalidDiceType(int diceType) {
		if (diceType != 1 && diceType != 2) {
			System.out.println("Invalid Dice Type:: " + diceType);
			return false;
		}
		return true;
	}

	private boolean validateStartEnd(int start, int end) {

		if (start > Constants.DEFAULT_BOARD_SIZE || end > Constants.DEFAULT_BOARD_SIZE) {
			System.out.println("Start/End value cannot exceed board size");
			return false;
		}

		if (start <= end) {
			System.out.println("Start should be strictly greater than end value");
			return false;
		}

		return true;
	}

	@Override
	public DiceType getDiceType() {

		while (true) {
			System.out.println("Select Dice Type:");
			System.out.println("1. Normal Type");
			System.out.println("2. Crooked Type");

			throwExceptionForInvalidValue();
			int diceType = Integer.parseInt(SCANNER.nextLine());

			boolean isValid = throwExceptionForInvalidDiceType(diceType);
			if (!isValid) {
				continue;
			}
			if (diceType == DiceType.NORMAL_DICE.ordinal()) {
				return DiceType.NORMAL_DICE;
			}
			return DiceType.CROOKED_DICE;
		}
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
		for (int i = 1; i <= snakeCount; i++) {
			System.out.println("Snake :: " + i);

			System.out.print("Start: ");
			throwExceptionForInvalidValue();
			int start = Integer.parseInt(SCANNER.nextLine());

			System.out.print("End: ");
			throwExceptionForInvalidValue();
			int end = Integer.parseInt(SCANNER.nextLine());

			// Add ->  start position > end position
			boolean isValidStartEnd = validateStartEnd(start, end);
			if (!isValidStartEnd) {
				i--;
				continue;
			}
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
