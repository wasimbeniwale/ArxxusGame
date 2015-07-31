package com.wasim.arxxusgame.global;

import com.uwsoft.editor.renderer.data.SceneVO;

public class AmbienceColorInfo {
	public SceneVO scenVO;
	public float[] whiteColor = { 1, 1, 1, 1 };
	public float[] redColor = { 1, 0, 0, 1 };
	public float[] greyColor = { 37, 37, 1, 1 };

	public AmbienceColorInfo() {
		scenVO = new SceneVO();
		scenVO.ambientColor = whiteColor;
	}

	public SceneVO setRedAmbience() {
		scenVO.ambientColor = redColor;
		return scenVO;
	}

	public SceneVO setWhiteAmbience() {
		scenVO.ambientColor = whiteColor;
		return scenVO;
	}

	public SceneVO setGreyAmbience() {
		scenVO.ambientColor = greyColor;
		return scenVO;
	}
}
