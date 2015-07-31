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

public class MilestoneStage extends Overlap2DStage implements Screen {

	ArxxusGame game;

	ImageItem imageBtnContinue;
	ImageItem imageRouter1, imageRouter2, imageBlade;

	String levelMessgae;
	String collectMessage;
	String impMessage;
	int level;

	public MilestoneStage(ArxxusGame game, int level) {
		this.game = game;
		this.level = level;
		levelMessgae = "Level : " + level;
		impMessage = "";
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("milestone_stage");
		addActor(sceneLoader.getRoot());

		imageBtnContinue = sceneLoader.sceneActor.getImageById("btn_continue");
		imageBlade = sceneLoader.sceneActor.getImageById("blade1");
		imageRouter1 = sceneLoader.sceneActor.getImageById("router1");
		imageRouter2 = sceneLoader.sceneActor.getImageById("router2");

		imageBlade.setOrigin(0);
		imageRouter1.setOrigin(0);
		imageRouter2.setOrigin(0);

		if (level < 4) {
			collectMessage = "Collect atleast : " + Data.LEVEL * 10 + " Coins";
		} else {
			collectMessage = "Defeat the deamon";
			impMessage = "Important tip : 'Follow the light...'";
		}

		Gdx.input.setInputProcessor(this);
		game.backTexture = new Texture(Gdx.files.internal("back/back8.png"));

		imageBtnContinue.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				switch (level) {
				case 2:
					game.levelTwo = new LevelTwo(game);
					game.setScreen((Screen) game.levelTwo);
					break;
				case 3:
					game.levelThree = new LevelThree(game);
					game.setScreen((Screen) game.levelThree);
					break;

				case 4:
					game.levelFour = new LevelFour(game);
					game.setScreen((Screen) game.levelFour);
					break;
				}
			}
		});
	}

	@Override
	public void act(float delta) {
		imageBlade.setRotation(imageBlade.getRotation() + 300 * delta);
		imageRouter1.setRotation(imageRouter1.getRotation() - 100 * delta);
		imageRouter2.setRotation(imageRouter2.getRotation() + 100 * delta);
		super.act(delta);
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.drawBackTexture(0, 0, 960, 540);

		game.spriteBatch.begin();
		game.scoreFont.setColor(Color.BLACK);
		game.scoreFont.draw(game.spriteBatch, levelMessgae, 300, 350);
		game.scoreFont.draw(game.spriteBatch, collectMessage, 300, 330);
		game.scoreFont.setColor(Color.RED);
		game.scoreFont.draw(game.spriteBatch, impMessage, 300, 500);
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
