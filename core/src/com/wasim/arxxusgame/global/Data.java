package com.wasim.arxxusgame.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Data {
	public static int LEVEL = 1;
	public static int SCORE = 0;
	public static int BEST_SCORE = 0;
	public static int COINS_COLLECTED = 0;
	public static boolean isMainStageLoaded = false;
	public static String PLAYR_NAME = "Player";
	public static String BEST_PLAYR_NAME = "BESTPLAYER";

	public static void saveData() {
		Preferences prefScores = Gdx.app.getPreferences("Pref_Score");
		prefScores.putString("name", PLAYR_NAME);
		prefScores.putInteger("level", LEVEL);
		prefScores.putInteger("score", SCORE);
		if (SCORE > BEST_SCORE) {
			prefScores.putInteger("bestscore", SCORE);
			prefScores.putString("bestplayer", PLAYR_NAME);
		}
		prefScores.flush();
	}

	public static void loadData() {
		Preferences prefScores = Gdx.app.getPreferences("Pref_Score");
		if (prefScores.contains("name")) {
			PLAYR_NAME = prefScores.getString("name");
			LEVEL = prefScores.getInteger("level");
			SCORE = prefScores.getInteger("score");
			BEST_SCORE = prefScores.getInteger("bestscore");
			BEST_PLAYR_NAME = prefScores.getString("bestplayer");
		} else {
			// if first application launch
			PLAYR_NAME = "Player";
			LEVEL = 1;
			SCORE = 0;
			BEST_SCORE = SCORE;
			BEST_PLAYR_NAME = PLAYR_NAME;
		}
		System.out.println(BEST_SCORE);
	}

	public static void clearAllData() {
		Preferences prefScores = Gdx.app.getPreferences("Pref_Score");
		if (prefScores.contains("name")) {
			prefScores.clear();
			prefScores.flush();

			System.out.println("All data is cleared");
		}
	}
}
