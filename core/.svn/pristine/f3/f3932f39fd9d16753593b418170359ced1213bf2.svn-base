package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.wasim.arxxusgame.ArxxusGame;

public class SplashScreen extends Overlap2DStage implements Screen {

	ArxxusGame game;
	float width, height;

	public SplashScreen(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("splash_screen");
		addActor(sceneLoader.getRoot());

		width = Gdx.graphics.getWidth() / 2;
		height = Gdx.graphics.getHeight() / 2;

		width = width - 100;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		act(delta);
		draw();
		if (Gdx.input.isTouched()) {
			game.setScreen(game.mainStage);
		}
		game.spriteBatch.begin();
		game.scoreFont.setColor(Color.BLACK);
		game.scoreFont.draw(game.spriteBatch, "Touch anywhere to start...",
				width, height);
		game.spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		System.out.println("At SplashScreen.dispose()");
		super.dispose();
	}

}
