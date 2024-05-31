package com.tictactoegame;

import com.tictactoegame.applicationpage.Application;

class StartPage {
	private StartPage() {
	}
	public static void main(String[] args) {
		Application app = Application.getInstance();
		app.initiateApp();
	}
}