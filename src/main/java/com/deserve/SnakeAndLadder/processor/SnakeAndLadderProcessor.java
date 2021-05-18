package com.deserve.SnakeAndLadder.processor;

import com.deserve.SnakeAndLadder.input.SnakeAndLadderInputReader;
import com.deserve.SnakeAndLadder.model.*;
import com.deserve.SnakeAndLadder.util.Constants;
import com.deserve.SnakeAndLadder.util.ProcessorUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderProcessor {

	private SnakeAndLadderInputReader snakeAndLadderInputReader;

	private int turns = Constants.TURNS; // Make the game run for 10 turns

	private Queue<Player> playersQueue = new LinkedList<>();

	public SnakeAndLadderProcessor(SnakeAndLadderInputReader snakeAndLadderInputReader) {
		this.snakeAndLadderInputReader = snakeAndLadderInputReader;
		playersQueue.add(new Player("Player_1"));
		playersQueue.add(new Player("Player_2"));
	}

	public void process() {
		System.out.println("Welcome to Snake And Ladder Game!!");

		// Story #1: Basic Board
		DiceType diceType = snakeAndLadderInputReader.getDiceType();

		// Story #2: Add a snake on the board
//		List<Snake> snakes = snakeAndLadderInputReader.getSnakes();

		List<Snake> snakes = getSnakes();
		
		Board board = new Board(diceType, snakes);
		System.out.println("Board created.");

		int currentTurn = 1;
		while(turns > 0){

			System.out.println("Turn :: " + currentTurn++);

			Player player = playersQueue.poll();
			System.out.println("Player :: " + player.getName());
			System.out.println("Current position, before dice rolled:: " + player.getCurrentPosition());

			//Dice roll
			int rollValue = ProcessorUtil.getValueAfterDiceRolls(diceType);

			//move player
			movePlayer(rollValue, snakes, player);


			System.out.println("Current position, after dice rolled:: " + player.getCurrentPosition());
			if(player.getCurrentPosition() == Constants.DEFAULT_BOARD_SIZE){
				System.out.println(player.getName()+" Won !!!!");
				break;
			}

			playersQueue.add(player);
			turns--;
		}

	}

	private List<Snake> getSnakes() {

		List<Snake> snakes = new ArrayList<>();

		snakes.add(new Snake(50, 2, SnakeType.ONE_BITE_SNAKE));
		snakes.add(new Snake(55, 4, SnakeType.NORMAL));
		snakes.add(new Snake(60, 9, SnakeType.ONE_BITE_SNAKE));
		snakes.add(new Snake(65, 12, SnakeType.ONE_BITE_SNAKE));

		return snakes;
	}

	private void movePlayer(int rollValue, List<Snake> snakes, Player player) {

		int currentPosition = player.getCurrentPosition();
		if(player.getCurrentPosition() + rollValue > Constants.DEFAULT_BOARD_SIZE){
			System.out.println("Input is out of range, can't move the player. Try again!!");
			return;
		}

		player.setCurrentPosition(currentPosition + rollValue);
		player.setCurrentPosition(ProcessorUtil.snakeCheck(currentPosition + rollValue, snakes));

	}

}
