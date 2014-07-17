package com.kilobolt.ZombieBird;

import com.badlogic.gdx.Game;
import com.kilobolt.ZBHelpers.AssetLoader;
import com.kilobolt.Screens.GameScreen;

public class ZBGame extends Game {

	@Override
	public void create() {
		System.out.println("ZBGame Created!");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
	
}
