package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Screen;
import com.wasim.arxxusgame.ArxxusGame;
import com.wasim.arxxusgame.global.Data;

public class LevelLoader {
	public void loadLevel(ArxxusGame game, int level) {
		if (level == 1 || Data.LEVEL == 1) {
			Data.LEVEL = 1;
			game.levelOne = new LevelOne(game);
			game.setScreen((Screen) game.levelOne);
		} else {
			Data.LEVEL = level;
			game.milestoneStage = new MilestoneStage(game, level);
			game.setScreen(game.milestoneStage);
		}
	}
}
