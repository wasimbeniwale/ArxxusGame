package com.wasim.arxxusgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.wasim.arxxusgame.ArxxusGame;
import com.wasim.arxxusgame.global.Data;
import com.wasim.arxxusgame.global.GameSoundEffects;

public class SettingsScreen extends Overlap2DStage implements Screen {

	ArxxusGame game;

	TextField textField;
	TextButton btnVolume;
	boolean volume = true;

	TextFieldStyle textFieldStyle;
	TextButtonStyle textButtonStyle;

	ImageItem imageBtnContinue, imageBtnClear;

	public SettingsScreen(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("settings");
		addActor(sceneLoader.getRoot());

		imageBtnContinue = sceneLoader.sceneActor.getImageById("btn_continue");
		imageBtnClear = sceneLoader.sceneActor.getImageById("btn_clear");

		textFieldStyle = new TextFieldStyle();
		textFieldStyle.fontColor = Color.WHITE;
		textFieldStyle.font = new BitmapFont();

		textField = new TextField(Data.PLAYR_NAME, textFieldStyle);
		textField.setPosition(280, 300);
		textField.setMessageText("Hello");

		textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = new BitmapFont();

		btnVolume = new TextButton("Music On", textButtonStyle);
		btnVolume.setPosition(280, 350);
		btnVolume.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				volume = !volume;
				if (volume) {
					GameSoundEffects.backMusic.setVolume(0);
					GameSoundEffects.gameOverMusic.setVolume(0);
					btnVolume.setText("Music Off");
				} else {
					GameSoundEffects.backMusic.setVolume(1);
					GameSoundEffects.backMusic.setPosition(0);
					GameSoundEffects.gameOverMusic.setVolume(1);
					GameSoundEffects.gameOverMusic.setPosition(0);
					btnVolume.setText("Music On");
				}
				System.out.println("Volume: " + volume);
			}
		});

		imageBtnContinue.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				String playerName = textField.getText();
				if (!playerName.equals("")) {
					Data.PLAYR_NAME = playerName;
					Data.saveData();
				}
				System.out.println(Data.PLAYR_NAME);

				game.mainStage = new MainStage(game);
				game.setScreen(game.mainStage);
			}
		});

		imageBtnClear.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Data.clearAllData();
				game.mainStage = new MainStage(game);
				game.setScreen(game.mainStage);
				Data.loadData();
			}
		});

		addActor(textField);
		addActor(btnVolume);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.spriteBatch.begin();
		game.scoreFont.setColor(Color.WHITE);
		game.scoreFont.draw(game.spriteBatch, "Player Name (Touch to Change)",
				50, 320);
		game.scoreFont.draw(game.spriteBatch,
				"Music Settings (Touch to Change)", 50, 370);
		game.spriteBatch.end();

		game.healthBar.setAutoShapeType(true);
		game.healthBar.begin();
		game.healthBar.setColor(Color.RED);
		game.healthBar.set(ShapeType.Filled);
		game.healthBar.rect(280, 300, 150, 30);
		game.healthBar.rect(280, 350, 150, 30);
		game.healthBar.end();

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

	@Override
	public void dispose() {
		System.out.println("At SettingsScreen.dispose()");
		super.dispose();
	}

}
