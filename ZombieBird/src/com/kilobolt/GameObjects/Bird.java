package com.kilobolt.GameObjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Bird {

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // for handling bird rotation
	private int width;
	private int height;
	
	private Circle boundingCircle;

	public Bird(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 460);
		boundingCircle = new Circle();
	}

	public void update(float delta) {
		velocity.add(acceleration.cpy().scl(delta)); /*
														* adds to the velocity vector a copy of the scaled acceleration vector.
														* Scaled means that we multiply the acceleration and velocity vectors by the delta, which is the amount of time that has passed since the update method was previously called. This has a normalizing effect. 
														* If the game slows down for any reason, the delta will go up (the processor will have taken longer time to complete the previous iteration, or repetition, of the loop). By scaling the Vectors with delta, we can achieve frame-rate independent movement. If the update method took twice as long to execute, then we just move our character by 2x the original velocity, and so on.
														*/
														
														
		if(velocity.y > 200) {
			velocity.y = 200;  //limits velocity to no more than 200
		}
		
		position.add(velocity.cpy().scl(delta));  // move the position of the bird based on the calculated velocity after being altered for acceleration
		
		// set the center of the circle to be (9, 6) relative to the bird.  Radius is 6.5f.
		boundingCircle.set(position.x + 9, position.y + 6, 6.5f);
		
		// rotate counterclockwise (if flying)
		if(velocity.y < 0) {
			rotation -= 600 * delta; // scales by delta time to compensate for varying speeds of devices
			if(rotation < -20) {
				rotation = -20; // limits counterclockwise rotation to no smaller than -20
			}
		}
		
		// rotate clockwise
		if(isFalling()) {
			rotation += 480 * delta; // scales by delta time to compensate for varying speds of devices
			if(rotation > 90) {
				rotation = 90; // limits clockwise rotation to no bigger than 90
			}
		}
	}

	public void onClick() {
		velocity.y = -140;
	}
	
	public boolean isFalling(){
		return velocity.y > 110; // if the bird is traveling down the y-axis faster than 110, then it is falling
	}
	
	public boolean shouldntFlap() {
		return velocity.y > 70; // if the bird is traveling down the y-axis faster than 70, then it shouldn't flap its wings
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getRotation() {
		return rotation;
	}
	
	public Circle getBoundingCircle() {
		return boundingCircle;
	}
}
