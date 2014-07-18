package com.kilobolt.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Scrollable {
	
	// Protected is similar to private, but protected allows subclass inheritance
	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;
	protected boolean isScrolledLeft;
	
	public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
		position = new Vector2(x, y);
		velocity = new Vector2(scrollSpeed, 0);
		this.width = width;
		this.height = height;
		isScrolledLeft = false;
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
		
		// If the Scrollable object is no longer visible
		if(position.x + width < 0){
			isScrolledLeft = true;
		}
	}
	
	// Reset: this should be overridden in a subclass for detailed behavior
	public void reset(float newX) {
		position.x = newX;
		isScrolledLeft = false;
	}
	
	public boolean isScrolledLeft() {
		return isScrolledLeft;
	}
	
	public float getTailX() {
		return position.x + width;
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
