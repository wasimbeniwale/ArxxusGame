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

public class GameWin extends Overlap2DStage implements Screen {

	ArxxusGame game;

	ImageItem imageBtnWin;

	public GameWin(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("game_won");
		addActor(sceneLoader.getRoot());

		Gdx.input.setInputProcessor(this);

		imageBtnWin = sceneLoader.sceneActor.getImageById("btn_win");
		imageBtnWin.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Win Button clicked");
				// game.mainStage=new MainStage(game);
				game.setScreen(game.mainStage);
			}
		});

		game.backTexture = new Texture(Gdx.files.internal("back/back5.png"));
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.spriteBatch.begin();
		game.spriteBatch.draw(game.backTexture, 0, 0, 960, 540);
		game.spriteBatch.end();

		act(delta);
		draw();

	}

	@Override
	public void resize(int width, int height) {

	}

	 
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
		System.out.println("At GameWin.dispose()");
		super.dispose();
	}

}
