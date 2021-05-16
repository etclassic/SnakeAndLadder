package com.deserve.SnakeAndLadder.input;

public class SnakeAndLadderDataReaderFactory {
	private static final SnakeAndLadderDataReaderFactory snakeAndLadderDataReaderFactory = new SnakeAndLadderDataReaderFactory();

	public static SnakeAndLadderDataReaderFactory getInstance() {
		return snakeAndLadderDataReaderFactory;
	}

	public SnakeAndLadderInputReader getReader() {
		return new ConsoleBasedInputReader();
	}}
