package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.wasim.arxxusgame.ArxxusGame;

public class HelpScreen extends Overlap2DStage implements Screen {

	ArxxusGame game;
	ImageItem imageBtnContinue;

	public HelpScreen(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("help_stage");
		addActor(sceneLoader.getRoot());

		Gdx.input.setInputProcessor(this);
		game.backTexture = new Texture(Gdx.files.internal("back/back2.png"));

		imageBtnContinue = sceneLoader.sceneActor.getImageById("btn_continue");
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
		super.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.6f, 0.6f, 0.6f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.drawBackTexture(0, 0, 960, 540);

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
