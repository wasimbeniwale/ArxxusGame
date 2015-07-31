package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.wasim.arxxusgame.ArxxusGame;
import com.wasim.arxxusgame.global.Data;

public class MainStage extends Overlap2DStage implements Screen {

	ArxxusGame game;
	CompositeItem itemWindMill;

	// buttons
	ImageItem imageBtnNew, imageBtnContinue, imageBtnScore, imageBtnHelp,
			imageBtnExit;
	ImageItem imageBtnSettings, imageBtnTwitter, imageBtnGoogle, imageBtnFb;
	ImageItem imageRouter;

	public MainStage(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("MainScene");
		addActor(sceneLoader.getRoot());

		// for button click
		// and no need for every stage as player controller sets its own input
		// processor
		Gdx.input.setInputProcessor(this);

		imageBtnNew = sceneLoader.sceneActor.getImageById("btn_new");
		imageBtnContinue = sceneLoader.sceneActor.getImageById("btn_continue");
		imageBtnScore = sceneLoader.sceneActor.getImageById("btn_score");
		imageBtnHelp = sceneLoader.sceneActor.getImageById("btn_help");
		imageBtnExit = sceneLoader.sceneActor.getImageById("btn_exit");
		imageBtnSettings = sceneLoader.sceneActor.getImageById("btn_settings");
		imageBtnTwitter = sceneLoader.sceneActor.getImageById("btn_twitter");
		imageBtnGoogle = sceneLoader.sceneActor.getImageById("btn_google");
		imageBtnFb = sceneLoader.sceneActor.getImageById("btn_fb");

		imageBtnNew.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:New Game");
				game.levelLoader.loadLevel(game, 1);
			}
		});

		imageBtnContinue.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Continue");
				game.levelLoader.loadLevel(game, Data.LEVEL);
			}
		});

		imageBtnScore.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Score");
				System.out.println("Player Name: " + Data.BEST_PLAYR_NAME);
				System.out.println("High Score: " + Data.BEST_SCORE);
				game.setScreen(game.scoreScreen);
			}
		});

		imageBtnHelp.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.helpScreen);
				System.out.println("Button clicked:Help");
			}
		});

		imageBtnExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Exit");
				Gdx.app.exit();
			}
		});

		imageBtnSettings.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button Settings");
				game.setScreen(game.settingsScreen);
			}
		});
		imageBtnTwitter.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Twitter");
				Gdx.net.openURI("https://twitter.com");
			}
		});
		imageBtnGoogle.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Google Plus");
				Gdx.net.openURI("https://plus.google.com");
			}
		});
		imageBtnFb.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button clicked:Facebook");
				Gdx.net.openURI("https://www.facebook.com");
			}
		});

		itemWindMill = sceneLoader.sceneActor.getCompositeById("wind_mill");
		imageRouter = itemWindMill.getImageById("router");
		imageRouter.setOrigin(0);

		game.backTexture = new Texture(Gdx.files.internal("back/back9.png"));
		Data.isMainStageLoaded = true;// if user exit from splash screen no
										// null pointer exception in dispose
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.spriteBatch.begin();
		game.spriteBatch.draw(game.backTexture, 0, 0, 960, 540);
		game.spriteBatch.end();

		act(delta);
		draw();
	}

	@Override
	public void act(float delta) {
		imageRouter.setRotation(imageRouter.getRotation() + 90 * delta);
		super.act(delta);
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
		imageBtnContinue.dispose();
		imageBtnExit.dispose();
		imageBtnHelp.dispose();
		imageBtnNew.dispose();
		imageBtnScore.dispose();
		itemWindMill.dispose();
		System.out.println("At MainStage.dispose()");
		super.dispose();
	}

}
