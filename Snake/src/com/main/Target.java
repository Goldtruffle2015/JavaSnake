package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Target {
	// -- Attributes -- //
	private int x, y; // Defines the position of the target
	private Color color;	// Defines the color of the target
	private int size = 36; // Defines the size of the target
	
	// -- Constructor -- //
	public Target(Color c) {
		this.color = c;
		this.x = (int) ((Math.round(Math.random() * 31.0)) * 36);
		this.y = (int) ((Math.round(Math.random() * 17.0)) * 36);
	}
	
	// -- Setter -- //
	
	// -- Getter -- //
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
	}
	
	// -- Methods -- //
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.size, this.size);
	}
	
	public void update(Player p) {
		if (this.x == p.getx() && this.y == p.gety()) {	// When the snake intersects the target
			this.x = (int) ((Math.round(Math.random() * 31.0)) * 36);	// Set random x-coordinate
			this.y = (int) ((Math.round(Math.random() * 17.0)) * 36);	// Set random y-coordinate
		}
	}
}
