package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	// -- Attributes -- //
	private int x, y; // Defines the position of the snake
	private int xVel, yVel;	// Either 1, 0, or -1
	private Color color; // Defines the color of the snake
	private int size = 36; // Defines the size of a snake pixel
	private int spd = 36; // Snake moves 36 pixels per frame
	
	// -- Constructor -- //
	public Player(Color c) {
		this.color = c; // Sets the color
		this.x = 576;	// Sets x-position at center
		this.y = 288;	// Sets y-position at center
		this.xVel = 1;	
		this.yVel = 0;
	}
	
	// -- Methods -- //
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.size, this.size);
	}
	
	public void update() {
		x += this.xVel * this.spd;
		y += this.yVel * this.spd;
	}
}
