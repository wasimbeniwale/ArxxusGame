package com.wasim.arxxusgame.global;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.wasim.arxxusgame.ArxxusGame;

public class PlayerDataRenderer {

	ArxxusGame game;

	public PlayerDataRenderer(ArxxusGame game) {
		this.game = game;
	}

	public void renderPlayerData() {
		game.spriteBatch.begin();
		game.scoreFont.setColor(Color.WHITE);
		game.scoreFont.draw(game.spriteBatch, "Score: " + Data.SCORE, 600, 500);
		game.scoreFont.draw(game.spriteBatch, "Coins collected:  "
				+ Data.COINS_COLLECTED, 450, 500);
		game.spriteBatch.end();

		game.healthBar.setAutoShapeType(true);
		game.healthBar.begin();
		game.healthBar.set(ShapeType.Filled);
		game.healthBar.setColor(Color.WHITE);
		game.healthBar.rect(90, 465, 210, 40);
		game.healthBar.setColor(Color.RED);
		game.healthBar.rect(100, 470, Life.health * 2, 30);
		game.healthBar.end();
	}

}
