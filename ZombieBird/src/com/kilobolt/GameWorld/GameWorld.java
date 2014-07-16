package com.kilobolt.GameWorld;

import com.kilobolt.GameObjects.Bird;

public class GameWorld {
	
	private Bird bird;
	
	public GameWorld(int midPointY){
		bird = new Bird(33, midPointY, 17, 12);
	}

	public void update(float delta) {
		
	}
	
	public Bird getBird() {
		return bird;
	}
}
