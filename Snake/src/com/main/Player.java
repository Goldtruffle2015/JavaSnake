package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	// -- Attributes -- //
	private int x, y; // Defines the position of the snake
	private boolean left = false; // True if the snake is going left
	private boolean right = false; // True if the snake is going right
	private boolean up = false; // True if the snake is going up
	private boolean down = false; // True if the snake is going down
	private Color color; // Defines the color of the snake
	private int size = 36; // Defines the size of a snake pixel
	
	// -- Constructor -- //
	public Player(Color c) {
		this.color = c; // Sets the color
		this.x = Game.WIDTH/2 - this.size/2;	// Sets x-position at center
		this.y = Game.HEIGHT/2 - this.size/2;	// Sets y-position at center
	}
	
	// -- Methods -- //
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.size, this.size);
	}
}
