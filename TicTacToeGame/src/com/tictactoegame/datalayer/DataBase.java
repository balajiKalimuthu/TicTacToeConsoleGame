package com.tictactoegame.datalayer;

import java.util.Arrays;

import com.tictactoegame.models.Player;

public class DataBase {
	private static DataBase data;
	private Player player1, player2;

	private char[][] array;
	private int count;

	private DataBase() {
	}

	public static DataBase getInstance() {
		if (data == null) {
			data = new DataBase();
		}
		return data;
	}

	public void intitatePlayer() {
		if (player1 == null && player2 == null) {
			player1 = new Player();
			player2 = new Player();
		}
		player1.setName('O');
		player2.setName('X');
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void newGame() {
		initializeGame();
	}

	private void initializeGame() {
		char[][] array = new char[3][3];
		setCount(9);
		for (int i = 0; i < 3; i++) {
			Arrays.fill(array[i], ' ');
		}
		this.array = array;
	}

	public char[][] getArray() {
		if (array == null) {
			initializeGame();
		}
		return array;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}