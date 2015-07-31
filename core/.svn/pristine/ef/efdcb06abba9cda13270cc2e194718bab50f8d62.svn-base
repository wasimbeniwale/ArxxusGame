package com.wasim.arxxusgame.controller;

public class PlayerCollisionHandler {

	public static boolean isOverlaps(float playerX, float playerY,
			float objectX, float objectY, float objectWidth, float objectHeight) {
		if (playerX >= objectX && playerX <= (objectX + objectWidth)) {
			if (playerY >= objectY && playerY <= objectY + objectHeight) {
				return true;
			}
		}
		return false;
	}
}
