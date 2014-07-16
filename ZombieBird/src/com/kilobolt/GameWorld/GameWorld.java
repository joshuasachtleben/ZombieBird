package com.kilobolt.GameWorld;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameWorld {

	private Rectangle rect = new Rectangle(0, 0, 12, 12); // create a rectangle (using the GDX library)
	private int xVel = 1;
	private int yVel = 1;

	public void update(float delta) {
		System.out.println("GameWorld - update()");
		rect.x = rect.x + xVel; //move on x-axis for each iteration
		rect.y = rect.y + yVel;
		if (rect.x + rect.width >= 136) xVel = -1;
		if (rect.x < 0) xVel = 1;
		if (rect.y + rect.height >= 204) yVel = -1;
		if (rect.y < 0) yVel = 1;
	}

	public Rectangle getRect() {
		return rect;
	}
}
