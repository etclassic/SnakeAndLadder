package com.deserve.SnakeAndLadder;

import java.util.Scanner;

import com.deserve.SnakeAndLadder.service.SnakeAndLadderService;

public class App {
	public static void main(String[] args) {

		System.out.println("######## Welcome to Snake And Ladder #######");
		try (Scanner scanner = new Scanner(System.in);) {
			SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
		}
	}
}
