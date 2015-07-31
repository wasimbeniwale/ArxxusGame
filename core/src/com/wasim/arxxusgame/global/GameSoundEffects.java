package com.wasim.arxxusgame.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class GameSoundEffects {
	public static Music backMusic, gameOverMusic, sawMusic, screamSound;

	public static Sound jumpSound, coinSound, deadSound, actionSound,
			bombExplosion, homeSound;

	public static void loadMusic() {
		backMusic = Gdx.audio.newMusic(Gdx.files
				.internal("audio/back.mp3"));
		backMusic.setVolume(1);
		backMusic.setLooping(true);
		gameOverMusic = Gdx.audio.newMusic(Gdx.files
				.internal("audio/game_over.ogg"));
		gameOverMusic.setLooping(true);
		sawMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/saw.ogg"));
		sawMusic.setLooping(true);
		screamSound = Gdx.audio
				.newMusic(Gdx.files.internal("audio/scream.ogg"));

		jumpSound = Gdx.audio.newSound(Gdx.files.internal("audio/jump.ogg"));
		coinSound = Gdx.audio.newSound(Gdx.files.internal("audio/coin.ogg"));
		deadSound = Gdx.audio.newSound(Gdx.files.internal("audio/dead.ogg"));
		homeSound = Gdx.audio.newSound(Gdx.files.internal("audio/home.ogg"));
		bombExplosion = Gdx.audio.newSound(Gdx.files
				.internal("audio/bomb_explosion.ogg"));

	}

	public static void disposeAllMusic() {
		screamSound.dispose();
		coinSound.dispose();
		bombExplosion.dispose();
		sawMusic.dispose();
		gameOverMusic.dispose();
		jumpSound.dispose();
		backMusic.dispose();
		deadSound.dispose();
		homeSound.dispose();
	}
}