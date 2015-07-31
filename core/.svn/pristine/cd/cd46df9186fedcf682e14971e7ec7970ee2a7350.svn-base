package com.wasim.arxxusgame.levels;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.uwsoft.editor.renderer.actor.SpriteAnimation;
import com.wasim.arxxusgame.ArxxusGame;
import com.wasim.arxxusgame.controller.PlayerCollisionHandler;
import com.wasim.arxxusgame.controller.PlayerController;
import com.wasim.arxxusgame.global.AmbienceColorInfo;
import com.wasim.arxxusgame.global.Data;
import com.wasim.arxxusgame.global.GameSoundEffects;
import com.wasim.arxxusgame.global.Life;

public class LevelFour extends Overlap2DStage implements Screen {

	// New Commit123

	ArxxusGame game;

	SpriteBatch batch;

	CompositeItem itemPlayer, itemLight, itemDeamon, itemLauncher,
			itemPlatform;
	ImageItem imagePause;
	CompositeItem itemBigSpike;
	SpriteAnimation launcherAnimation;
	PlayerController playerController;

	AmbienceColorInfo ambienceColorInfo = new AmbienceColorInfo();

	Texture textureFireBall, textureBomb;
	Array<Rectangle> fireBalls, bombs;
	private long lastFireBallTime, lastBombTime;

	float deamonHealth = 100;
	float deamonX, deamonY;
	float playerX, playerY;
	float platformX, platformY, platformWidth, platformHeight;

	public LevelFour(ArxxusGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		clear();
		initSceneLoader();
		sceneLoader.loadScene("level_four");
		addActor(sceneLoader.getRoot());

		itemPlayer = sceneLoader.sceneActor.getCompositeById("player");
		playerController = new PlayerController(this);
		itemPlayer.addScript(playerController);

		itemLight = sceneLoader.sceneActor.getCompositeById("item_light");
		itemDeamon = sceneLoader.sceneActor.getCompositeById("deamon");
		itemLauncher = sceneLoader.sceneActor.getCompositeById("bomb_launcher");
		itemPlatform = sceneLoader.sceneActor.getCompositeById("platform");
		itemBigSpike = sceneLoader.sceneActor
				.getCompositeById("item_big_spike");

		imagePause = sceneLoader.sceneActor.getImageById("btnPause");
		imagePause.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.pauseAndPlayGame();
			}
		});

		launcherAnimation = itemLauncher.getSpriteAnimationById("animation");
		launcherAnimation.pause();

		batch = new SpriteBatch();

		deamonX = itemDeamon.getX();
		deamonY = itemDeamon.getY() + 30;

		platformX = itemPlatform.getX() - 40;
		platformY = itemPlatform.getY();
		platformWidth = itemPlatform.getWidth();
		platformHeight = itemPlatform.getHeight() + 50;

		textureFireBall = new Texture(Gdx.files.internal("back/fire_ball.png"));
		fireBalls = new Array<Rectangle>();

		textureBomb = new Texture(Gdx.files.internal("back/bomb_small.png"));
		bombs = new Array<Rectangle>();

		game.backTexture = new Texture(Gdx.files.internal("back/back8.png"));

		spawnFireBalls();
		spawnBombs();

		Data.LEVEL = 4;
		Data.COINS_COLLECTED = 0;
		Life.health = 100;
		// Data.saveData();
	}

	private void spawnBombs() {
		Rectangle bomb = new Rectangle();
		bomb.x = itemLauncher.getX() - 30;
		bomb.y = itemLauncher.getY() + 150;
		bomb.width = 80;
		bomb.height = 80;
		bombs.add(bomb);
		lastBombTime = TimeUtils.nanoTime();
	}

	private void spawnFireBalls() {
		Rectangle fireBall = new Rectangle();
		fireBall.x = MathUtils.random(deamonX - 100, deamonX + 180);
		fireBall.y = deamonY;
		fireBall.width = 120;
		fireBall.height = 120;
		fireBalls.add(fireBall);
		lastFireBallTime = TimeUtils.nanoTime();
	}

	@Override
	public void act(float delta) {

		playerX = itemPlayer.getX();
		playerY = itemPlayer.getY();

		// movable light
		itemLight.setX(itemLight.getX() + 2);
		itemLight.setY(itemPlayer.getY());

		// pause button
		imagePause.setX(playerX - 150);
		imagePause.setY(playerY + 320);

		if (PlayerCollisionHandler.isOverlaps(playerX, playerY,
				itemBigSpike.getX(), itemBigSpike.getY(),
				itemBigSpike.getWidth(), itemBigSpike.getHeight())) {
			Life.health -= 0.5;
			System.out.println("Life-- at big spike");
			if (!GameSoundEffects.screamSound.isPlaying()) {
				GameSoundEffects.screamSound.play();
			}
		}
		// draw fireballs
		else if (playerX > platformX - 400) {
			batch.begin();
			for (Rectangle fireBall : fireBalls) {
				batch.draw(textureFireBall, fireBall.x, fireBall.y);
			}
			batch.end();

			if (TimeUtils.nanoTime() - lastFireBallTime > 1000000000) {
				spawnFireBalls();
			}

			Iterator<Rectangle> iter = fireBalls.iterator();
			while (iter.hasNext()) {
				Rectangle fireBall = iter.next();

				float ballWidth, ballHeight;
				float ballX = fireBall.getX() - 60;
				float ballY = fireBall.getY();
				ballWidth = fireBall.getWidth();
				ballHeight = fireBall.getHeight();
				fireBall.y -= 200 * delta;

				if (PlayerCollisionHandler.isOverlaps(playerX, playerY, ballX,
						ballY, ballWidth, ballHeight)) {
					Life.health -= 2;
					System.out.println("Life-- at fireball");
					// ambient color
					// sceneLoader.setAmbienceInfo(ambienceColorInfo.setRedAmbience());
					if (!GameSoundEffects.screamSound.isPlaying()) {
						GameSoundEffects.screamSound.play();
					}
				}

				if (fireBall.y < 30) {
					iter.remove();
				}
			}// end of while
		}
		// player at platform and draw bomb

		if (PlayerCollisionHandler.isOverlaps(playerX, playerY, platformX,
				platformY, platformWidth, platformHeight)) {
			launcherAnimation.resume();
			batch.begin();
			for (Rectangle bomb : bombs) {
				batch.draw(textureBomb, bomb.x, bomb.y);
			}
			batch.end();
			if (TimeUtils.nanoTime() - lastBombTime > 1000000000) {
				spawnBombs();
			}
			Iterator<Rectangle> bombItr = bombs.iterator();
			while (bombItr.hasNext()) {
				Rectangle bomb = bombItr.next();
				bomb.y += 300 * delta;
				bomb.x -= 300 * delta;

				if (bomb.y > deamonY) {
					GameSoundEffects.bombExplosion.play();
					bombItr.remove();
					deamonHealth -= 1;
					Data.SCORE += 50;
					System.out.println("DeamonHealth: " + deamonHealth);
				}
			}
		} else {
			launcherAnimation.pause();
		}

		super.act(delta);
	}

	@Override
	public void render(float delta) {
		if (!Life.dead) {
			if (deamonHealth > 5) {
				Gdx.gl.glClearColor(0, 0, 0, 1);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

				game.drawBackTexture(0, 0, 960, 540);

				sceneLoader.sceneActor.getStage().getCamera().update();
				batch.setProjectionMatrix(sceneLoader.sceneActor.getStage()
						.getCamera().combined);

				act(delta);
				draw();

				// playerDataRenderer.renderPlayerData();
				game.healthBar.setAutoShapeType(true);
				game.healthBar.begin();
				game.healthBar.set(ShapeType.Filled);
				game.healthBar.setColor(Color.WHITE);
				game.healthBar.rect(90, 465, 210, 40);
				game.healthBar.setColor(Color.RED);
				game.healthBar.rect(100, 470, Life.health * 2, 30);
				game.healthBar.end();

				game.healthBar.setAutoShapeType(true);
				game.healthBar.begin();
				game.healthBar.set(ShapeType.Filled);
				game.healthBar.setColor(Color.WHITE);
				game.healthBar.rect(500, 465, 210, 40);
				game.healthBar.setColor(Color.GREEN);
				game.healthBar.rect(500, 470, deamonHealth * 2, 30);
				game.healthBar.end();
			} else {
				GameSoundEffects.homeSound.play();
				game.setScreen(game.gameWin);
			}

		} else {
			game.setScreen(game.gameOver);
		}

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
		System.out.println("At LevelFour.dispose()");
		super.dispose();
	}

}
