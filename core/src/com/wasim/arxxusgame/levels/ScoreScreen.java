package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.wasim.arxxusgame.ArxxusGame;
import com.wasim.arxxusgame.global.Data;

public class ScoreScreen extends Overlap2DStage implements Screen {

	ArxxusGame game;
	ImageItem imageBtnContinue, imageRouter;

	public ScoreScreen(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("score_stage");
		addActor(sceneLoader.getRoot());

		Gdx.input.setInputProcessor(this);
		game.backTexture = new Texture(Gdx.files.internal("back/back8.png"));

		imageBtnContinue = sceneLoader.sceneActor.getImageById("btn_continue");
		imageRouter = sceneLoader.sceneActor.getImageById("router");

		imageRouter.setOrigin(0);
		imageBtnContinue.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.mainStage = new MainStage(game);
				game.setScreen(game.mainStage);
			}
		});

	}

	@Override
	public void act(float delta) {
		imageRouter.setRotation(imageRouter.getRotation() + 100 * delta);
		super.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.drawBackTexture(0, 0, 960, 540);

		game.spriteBatch.begin();
		game.scoreFont.setColor(Color.WHITE);
		game.scoreFont.draw(game.spriteBatch, "Player Name : "
				+ Data.BEST_PLAYR_NAME, 500, 370);
		game.scoreFont.draw(game.spriteBatch, "Score : " + Data.BEST_SCORE,
				500, 320);
		game.spriteBatch.end();

		act(delta);
		draw();
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

}
