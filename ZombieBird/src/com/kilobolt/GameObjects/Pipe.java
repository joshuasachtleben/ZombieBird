package com.kilobolt.GameObjects;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;

public class Pipe extends Scrollable {
	
	private Random r;
	
	private Rectangle skullUp, skullDown, barUp, barDown;
	
	// Constants to represent 45-pixel gap between upper and lower pipe as well as skull info
	public static final int VERTICAL_GAP = 45;
	public static final int SKULL_WIDTH = 24;
	public static final int SKULL_HEIGHT = 11;
	
	private float groundY;  // finds out where the ground is
	
	public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {
		super(x, y, width, height, scrollSpeed);
		// Initialize a Random object for random number generation
		r = new Random();
		skullUp = new Rectangle();
		skullDown = new Rectangle();
		barUp = new Rectangle();
		barDown = new Rectangle();
		this.groundY = groundY;
	}
	
	@Override
	public void update(float delta) {
		// Call the superclass' method first to run that code
		super.update(delta);
		
		// the set() method allows the ability to set the top, left corner's x, y coordinates along with width/height of rectangle
		barUp.set(position.x, position.y, width, height);
		barDown.set(position.x, position.y + height + VERTICAL_GAP, width, groundY - (position.y + height + VERTICAL_GAP));
		
		// The skull width is 24.  The bar is only 22 pixels wide, so the skull needs to be shifted 1 pixel to the left to center it.
		// Shift is done by: (SKULL_WIDTH - width) / 2
		skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
		skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y, SKULL_WIDTH, SKULL_HEIGHT);
	}
	
	@Override
	public void reset(float newX) {
		// Call the reset method in the superclass Scrollable
		super.reset(newX);
		// Change the height to a random number
		height = r.nextInt(90) + 15;
	}
	
	public Rectangle getSkullUp() {
		return skullUp;
	}
	
	public Rectangle getSkullDown() {
		return skullDown;
	}
	
	public Rectangle getBarUp() {
		return barUp;
	}
	
	public Rectangle getBarDown() {
		return barDown;
	}

}
