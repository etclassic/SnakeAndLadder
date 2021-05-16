package com.deserve.SnakeAndLadder;

import com.deserve.SnakeAndLadder.input.SnakeAndLadderDataReaderFactory;
import com.deserve.SnakeAndLadder.input.SnakeAndLadderInputReader;
import com.deserve.SnakeAndLadder.processor.SnakeAndLadderProcessor;

public class App {
	public static void main(String[] args) {

		SnakeAndLadderInputReader snakeAndLadderInputReader = SnakeAndLadderDataReaderFactory.getInstance()
				.getReader();
		new SnakeAndLadderProcessor(snakeAndLadderInputReader).process();
	}
}
