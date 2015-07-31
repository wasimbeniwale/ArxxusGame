package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.wasim.arxxusgame.ArxxusGame;
import com.wasim.arxxusgame.global.Data;
import com.wasim.arxxusgame.global.GameSoundEffects;
import com.wasim.arxxusgame.global.Life;

public class GameOver extends Overlap2DStage implements Screen {
	ArxxusGame game;

	CompositeItem itemWindMill;
	ImageItem imageRouter, imageBtnMenu, imageBtnRetry;

	public GameOver(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("game_over");
		addActor(sceneLoader.getRoot());

		Gdx.input.setInputProcessor(this);

		itemWindMill = sceneLoader.sceneActor.getCompositeById("wind_mill");
		imageRouter = itemWindMill.getImageById("router");
		imageRouter.setOrigin(0);

		imageBtnRetry = sceneLoader.sceneActor.getImageById("btn_retry");
		imageBtnMenu = sceneLoader.sceneActor.getImageById("btn_exit");

		imageBtnMenu.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Menu");
				GameSoundEffects.disposeAllMusic();
				Gdx.app.exit();
			}
		});

		imageBtnRetry.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameSoundEffects.gameOverMusic.stop();
				GameSoundEffects.backMusic.play();
				System.out.println("Button clicked:Retry");
				Life.inputProcessorNotStopped = true;
				Life.dead = false;
				game.levelLoader.loadLevel(game, Data.LEVEL);
			}
		});

		GameSoundEffects.backMusic.stop();
		GameSoundEffects.gameOverMusic.play();

	}

	@Override
	public void act(float delta) {
		imageRouter.setRotation(imageRouter.getRotation() + 100 * delta);
		super.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		act(delta);
		draw();

		game.spriteBatch.begin();
		game.scoreFont.setColor(Color.WHITE);
		game.scoreFont.draw(game.spriteBatch, "Your Name: " + Data.PLAYR_NAME,
				300, 450);
		game.scoreFont.draw(game.spriteBatch, "Your Score: " + Data.SCORE, 300,
				400);
		game.scoreFont.draw(game.spriteBatch, "Best Score: " + Data.BEST_SCORE,
				300, 350);
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
		System.out.println("At GameOver.dispose()");
		super.dispose();
	}

}
