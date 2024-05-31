package com.tictactoegame.gamepage;

import java.util.Scanner;

import com.tictactoegame.applicationpage.Application;

public class GameView {
	private Application app = Application.getInstance();
	private GameViewModel modelPage;
	private Scanner sc = new Scanner(System.in);
	private boolean run, valid, isAssigned;
	private char player;
	private int count, row, col;

	public GameView() {
		modelPage = new GameViewModel(this);
	}
	
	public void pageDetails() {
		start();
		initiatePage();
		end();
	}

	private void initiatePage() {
		modelPage.initiatePlayer();
		do {
			try {
				showChoiceTable();
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					newGame();
					break;
				case 0:
					run = true;
					break;
				default:
					showMessage("\nPlease enter valid input...\n");
				}
			} catch (Exception e) {
				showMessage("\nPlease enter valid input...\n");
				sc.nextLine();
			}
		} while (!run);
	}

	private void newGame() {
		modelPage.newGame();
		setPlayer(modelPage.switchPlayer(!valid, player));
		setCount(modelPage.getCount());
		modelPage.printBoard();
		do {
			try {
				showMessage("\nRow    : ");
				row = sc.nextInt();
				showMessage("Column : ");
				col = sc.nextInt();
				isAssigned = modelPage.assignValue(player, row, col);
				modelPage.printBoard();
				valid = modelPage.checkValues(isAssigned, player, row, col);
				setCount(modelPage.getCount());
			} catch (Exception e) {
				showMessage("\nPlease enter valid input...\n");
				sc.nextLine();
			}
		} while (!valid && count > 0);
	}

	public void setPlayer(char player) {
		this.player = player;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void showMessage(String message) {
		System.out.print(message);
	}
	
	private void start() {
		showMessage("\t+------------------+\n");
		showMessage("\t| "+ app.getName() +" Game |\n");
		showMessage("\t|     -"+ app.getVersion() +"     |\n");
		showMessage("\t+------------------+\n\n");
	}
	
	private void end() {
		showMessage("\n\n+-----------------------------------+\n");
		showMessage("| THANKS FOR USING "+ app.getName() +" Game |\n");
		showMessage("+-----------------------------------+\n");
	}
	
	private void showChoiceTable() {
		showMessage("\t+-------------------+\n");
		showMessage("\t|     Game Menu     |\n");
		showMessage("\t+-------------------+\n");
		showMessage("\t| 1. New Game       |\n");
		showMessage("\t| 0. Exit Game      |\n");
		showMessage("\t+-------------------+\n");
		showMessage("\n      Choice : ");
	}
}