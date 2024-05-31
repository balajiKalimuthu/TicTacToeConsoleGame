package com.tictactoegame.gamepage;

import com.tictactoegame.datalayer.DataBase;

class GameViewModel {
	private DataBase data = DataBase.getInstance();
	private char[][] array = data.getArray();
	private GameView viewPage;

	public GameViewModel(GameView viewPage) {
		this.viewPage = viewPage;
	}

	public void initiatePlayer() {
		data.intitatePlayer();
	}

	public void newGame() {
		data.newGame();
	}

	public void printBoard() {
		int row, col;
		viewPage.showMessage("\n  +----+----+----+   +---+---+---+\n");
		viewPage.showMessage("  |    POINTER   |   |    GAME   |\n");
		viewPage.showMessage("  +----+----+----+   +---+---+---+\n");
		for (row = 0; row < 3; row++) {
			viewPage.showMessage("  ");
			for (col = 0; col < 3; col++) {
				viewPage.showMessage("| " + row + "" + col + " ");
			}
			viewPage.showMessage("|   ");
			for (col = 0; col < 3; col++) {
				viewPage.showMessage("| " + array[row][col] + " ");
			}
			viewPage.showMessage("|\n  +----+----+----+   +---+---+---+\n");
		}
	}

	public boolean assignValue(char player, int row, int col) {
		if (row < 0 || row > 2 || col < 0 || col > 2 || array[row][col] != ' ') {
			viewPage.showMessage("\nInvalid move...\n");
			return false;
		}
		array[row][col] = player;
		data.setCount(data.getCount() - 1);
		return true;
	}

	public boolean checkValues(boolean isAssigned, char player, int row, int col) {
		if (isAssigned) {
			if (player == array[row][0] && array[row][0] == array[row][1] && array[row][1] == array[row][2]) {
				result(player);
				return true;
			}
			if (player == array[0][col] && array[0][col] == array[1][col] && array[1][col] == array[2][col]) {
				result(player);
				return true;
			}
			if (row == col && player == array[0][0] && array[0][0] == array[1][1]
					&& array[1][1] == array[2][2]) {
				result(player);
				return true;
			}
			if ((row == 1 && col == 1) || (row == 0 && col == 2) || (row == 2 && col == 0)) {
				if (player == array[0][2] && array[0][2] == array[1][1] && array[1][1] == array[2][0]) {
					result(player);
					return true;
				}
			}
			viewPage.setPlayer(switchPlayer(true, player));
		}
		return false;
	}

	public int getCount() {
		return data.getCount();
	}

	public char switchPlayer(boolean valid, char player) {
		if (valid || player == ' ') {
			if (player == ' ') {
				player = data.getPlayer1().getName();
			} else {
				player = (player == data.getPlayer1().getName()) ? data.getPlayer2().getName()
						: data.getPlayer1().getName();
			}
		}
		if(getCount() > 0) {
			viewPage.showMessage("\nCurrent Player : "+ player + "\n");
		} else {
			result(player);
		}
		return player;
	}
	
	public void result(char player) {
		if(getCount() == 0) {
			viewPage.showMessage("\nDraw Match...\n");
		} else {
			if(player == data.getPlayer1().getName()) {
				viewPage.showMessage("\nWinner : Player 1\n");
			} else {
				viewPage.showMessage("\nWinner : Player 2\n");
			}
		}
	}
}