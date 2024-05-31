package com.tictactoegame.applicationpage;

import com.tictactoegame.gamepage.GameView;

public class Application {
	private static Application app;
	private String name = "TIC TAC TOE";
	private String version = "v 1.0.0";

	private Application() {
	}

	public static Application getInstance() {
		if (app == null) {
			app = new Application();
		}
		return app;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void initiateApp() {
		new GameView().pageDetails();
	}
}