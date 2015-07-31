package com.wasim.arxxusgame.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.SpriteAnimation;
import com.uwsoft.editor.renderer.physics.PhysicsBodyLoader;
import com.uwsoft.editor.renderer.script.IScript;
import com.wasim.arxxusgame.global.GameSoundEffects;
import com.wasim.arxxusgame.global.Life;

public class PlayerController implements IScript {
	Overlap2DStage stage;
	CompositeItem item;
	SpriteAnimation animation;

	// touchpad
	Touchpad touchPad, touchPadJump;
	TouchpadStyle touchPadStyle;
	Skin touchPadSkin;
	Drawable touchBack, touchKnob;

	boolean isGoToLeftEnabled = false;
	boolean isGoToRightEnabled = false;
	boolean isJumpEnabled = false;

	public PlayerController(Overlap2DStage stage) {
		this.stage = stage;
	}

	@Override
	public void init(CompositeItem item) {

		this.item = item;
		animation = item.getSpriteAnimationById("animation");

		animation.pause();

		item.setOrigin(item.getWidth() / 2, 0);

		// touchpad
		touchPadSkin = new Skin();
		touchPadSkin.add("touchBackground", new Texture(
				"back/joystick_background2.png"));
		touchPadSkin.add("touchKnob", new Texture("back/touchKnob.png"));

		touchPadStyle = new TouchpadStyle();

		touchBack = touchPadSkin.getDrawable("touchBackground");
		touchKnob = touchPadSkin.getDrawable("touchKnob");

		touchPadStyle.background = touchBack;
		touchPadStyle.knob = touchKnob;

		touchPad = new Touchpad(10, touchPadStyle);

		// touchPadJump
		touchPadSkin = new Skin();
		touchPadSkin.add("touchBackground", new Texture(
				"back/touchBackground.png"));
		touchPadSkin.add("touchKnob", new Texture("back/jump.png"));

		touchPadStyle = new TouchpadStyle();

		touchBack = touchPadSkin.getDrawable("touchBackground");
		touchKnob = touchPadSkin.getDrawable("touchKnob");

		touchPadStyle.knob = touchKnob;
		touchPadJump = new Touchpad(10, touchPadStyle);

		touchPadJump.setSize(150, 150);

		stage.addActor(touchPad);
		stage.addActor(touchPadJump);
		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void act(float delta) {

		if (Life.inputProcessorNotStopped) {

			stage.getCamera().position.x = item.getX();
			stage.getCamera().position.y = item.getY() + 140;
			touchPad.setPosition(item.getX() - 380, item.getY() - 80);
			touchPadJump.setPosition(item.getX() + 200, item.getY() - 70);

			if (!Life.dead) {

				// touchpad
				if (touchPad.isTouched()) {
					animation.resume();
					item.setX(item.getX() + touchPad.getKnobPercentX() * 5);
					if (touchPad.getKnobPercentX() < 0) {
						item.setScaleX(-1f);
					} else {
						item.setScaleX(1f);
					}
				} else {
					animation.pause();
				}

				if (touchPadJump.isTouched()) {
					isJumpEnabled = true;
				}

				if (item.getY() < -90) {
					GameSoundEffects.deadSound.play();
					Life.dead = true;
				}

				// keyboard

				boolean wasWalking = Life.walking;
				Life.walking = false;

				if (Gdx.input.isKeyPressed(Keys.LEFT)) {
					isGoToLeftEnabled = true;
				} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
					isGoToRightEnabled = true;
				}

				if (Gdx.input.isKeyJustPressed(Keys.UP)) {
					isJumpEnabled = true;
				}

				if (shouldGoToRight()) {
					item.setX(item.getX() + delta * Life.moveSpeed);
					item.setScaleX(1f);
					Life.walking = true;
					animation.resume();
				} else if (shouldGoToLeft()) {
					item.setX(item.getX() - delta * Life.moveSpeed);
					item.setScaleX(-1f);
					Life.walking = true;
					animation.resume();
				}

				if (shouldJump()) {
					if (Life.grounded) {
						GameSoundEffects.jumpSound.play();
						Life.verticalSpeed = 400f;
						Life.grounded = false;
					}
				}

				if (wasWalking == true && Life.walking == false) {
					animation.pause();
				} else if (wasWalking == false && Life.walking == true) {
					animation.resume();
				}

				// gravity
				Life.verticalSpeed += Life.gravity * delta;
				// ray-casting for collision detection
				checkForCollision();
				// set the position
				item.setY(item.getY() + Life.verticalSpeed * delta);

				setGoToLeftEnabled(false);
				setGoToRightEnabled(false);
				setJumpEnabled(false);

				if (Life.health < 1) {
					Life.dead = true;
				}

			} else {
				// player is dead
				Life.inputProcessorNotStopped = false;
				GameSoundEffects.backMusic.stop();
			}
		}
	}

	private boolean shouldGoToRight() {
		return isGoToRightEnabled;
	}

	private boolean shouldGoToLeft() {
		return isGoToLeftEnabled;
	}

	private boolean shouldJump() {
		return isJumpEnabled;
	}

	private void setGoToRightEnabled(boolean value) {
		isGoToRightEnabled = value;
	}

	private void setJumpEnabled(boolean value) {
		isJumpEnabled = value;
	}

	private void setGoToLeftEnabled(boolean value) {
		isGoToLeftEnabled = value;
	}

	private void checkForCollision() {

		float rayGap = item.getHeight() / 2;

		float raySize = -(Life.verticalSpeed + Gdx.graphics.getDeltaTime())
				* Gdx.graphics.getDeltaTime();

		if (raySize < 5f)
			raySize = 5f;

		if (Life.verticalSpeed > 0)
			return;

		Vector2 rayFrom = new Vector2((item.getX() + item.getWidth() / 2)
				* PhysicsBodyLoader.SCALE, (item.getY() + rayGap)
				* PhysicsBodyLoader.SCALE);

		Vector2 rayTo = new Vector2((item.getX() + item.getWidth() / 2)
				* PhysicsBodyLoader.SCALE, (item.getY() - raySize)
				* PhysicsBodyLoader.SCALE);

		// cast the ray
		stage.getWorld().rayCast(new RayCastCallback() {

			@Override
			public float reportRayFixture(Fixture fixture, Vector2 point,
					Vector2 normal, float fraction) {

				// stop the player
				Life.verticalSpeed = 0;

				// reposition player slightly upper the collision point
				item.setY(point.y / PhysicsBodyLoader.SCALE + 0.1f);

				// make sure it is grounded, to allow jumping again
				Life.grounded = true;
				// jumpCounter = 0;

				return 0;
			}
		}, rayFrom, rayTo);

	}

	@Override
	public void dispose() {
		System.out.println("In dispose:PlayerController");
	}

}
