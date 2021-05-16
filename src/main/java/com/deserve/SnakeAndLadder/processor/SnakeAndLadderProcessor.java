package com.deserve.SnakeAndLadder.processor;

import com.deserve.SnakeAndLadder.input.SnakeAndLadderInputReader;
import com.deserve.SnakeAndLadder.model.Board;
import com.deserve.SnakeAndLadder.model.DiceType;
import com.deserve.SnakeAndLadder.model.Player;
import com.deserve.SnakeAndLadder.model.Snake;
import com.deserve.SnakeAndLadder.service.DiceService;
import com.deserve.SnakeAndLadder.util.Constants;

import java.util.List;

public class SnakeAndLadderProcessor {

	private SnakeAndLadderInputReader snakeAndLadderInputReader;

	public static final  Player player = new Player("Player_1"); // Design it for a single player

	private int turns = Constants.TURNS; // Make the game run for 10 turns
	private int currentPosition = 0;

	public SnakeAndLadderProcessor(SnakeAndLadderInputReader snakeAndLadderInputReader) {
		this.snakeAndLadderInputReader = snakeAndLadderInputReader;
	}


	private int getValueAfterDiceRolls(DiceType diceType) {

		int diceValue = DiceService.roll(diceType);
		System.out.println("Dice rolled, gives value :: " + diceValue);
		return diceValue;
	}

	public void process() {
		System.out.println("Welcome to Snake And Ladder Game!!");

		// Story #1: Basic Board
		DiceType diceType = snakeAndLadderInputReader.getDiceType();

		// Story #2: Add a snake on the board
		List<Snake> snakes = snakeAndLadderInputReader.getSnakes();

		Board board = new Board(diceType, snakes);
		System.out.println("Board created.");

		int currentTurn = 1;
		while(turns > 0){

			System.out.println("Turn :: " + currentTurn++);

			System.out.println("Current position, before dice rolled:: " + currentPosition);

			//Dice roll
			int rollValue = getValueAfterDiceRolls(diceType);

			//move player
			movePlayer(rollValue, snakes);


			System.out.println("Current position, after dice rolled:: " + currentPosition);
			turns--;
		}

	}

	private void movePlayer(int rollValue, List<Snake> snakes) {

		if(currentPosition + rollValue > Constants.DEFAULT_BOARD_SIZE){
			System.out.println("Input is out of range, can't move the player. Try again!!");
		}

		currentPosition = currentPosition + rollValue;
		currentPosition = snakeCheck(currentPosition, snakes);

	}

	private int snakeCheck(int currentPos, List<Snake> snakes) {

		for (Snake snake: snakes) {
			if(snake.getStart() == currentPos){
				System.out.println("Snake found at :: " + snake.getStart());
				currentPos = snake.getEnd();
				System.out.println("Sending player to snake's end :: " + snake.getEnd());
				break;
			}
		}

		return currentPos;
	}

}
