package com.kilobolt.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	public GameRenderer(GameWorld world) {
		myWorld = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, 204); // this will be scaled to the resolution in Main.java in ZombieBird-desktop.
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
		System.out.println("GameRenderer - render()");

		/* 1. Draw a black background to prevent flickering */

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		/* 2. Draw a filled rectangle */

		// Tells shapeRenderer to begin drawing filled shapes
		shapeRenderer.begin(ShapeType.Filled);

		// Chooses RGB Color of (16, 35, 144) at full opacity
		shapeRenderer.setColor(16 / 255.0f, 35 / 255.0f, 144 / 255.0f, 1);

		// Draws the rectangle from myWorld (using ShapeType.Filled)
		shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, myWorld.getRect().width, myWorld.getRect().height);

		// Tells the shapeRenderer to finish rendering...must do this every time
		shapeRenderer.end();

		/* 3. Draw the rectangle's outline */

		// Tells shapeRenderer to begin drawing an outline of a shape
		shapeRenderer.begin(ShapeType.Line);

		// Chooses RGB Color of (255, 255, 255) at full opacity
		shapeRenderer.setColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);
		
		// Draws the rectangle from myWorld (using ShapeType.Line)
		shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, myWorld.getRect().width, myWorld.getRect().height);
		
		// Tells the shapeRenderer to finish rendering...must do this every time
		shapeRenderer.end();
	}

}
