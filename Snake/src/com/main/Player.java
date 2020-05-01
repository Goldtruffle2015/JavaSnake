package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player {
	// -- Attributes -- //
	private int x, y; // Defines the position of the snake head
	private int xVel, yVel;	// Either 1, 0, or -1
	private Color color; // Defines the color of the snake
	private int size = 36; // Defines the size of a snake pixel
	private int spd = 36; // Snake moves 36 pixels per frame
	private ArrayList<Body> bodies = new ArrayList<Body>();	// Stores all the bodies of the snake
	
	// -- Constructor -- //
	public Player(Color c) {
		this.color = c; // Sets the color
		this.x = 576;	// Centers the snake
		this.y = 288;	// Centers the snake
		this.xVel = 1;	
		this.yVel = 0;
		this.bodies.add(new Body(this.color, this.x, this.y));	// Set initial position of the snake at the center
	}
	
	// -- Setters -- //
	public void setxVel(int var) {
		this.xVel = var;
	}
	
	public void setyVel(int var) {
		this.yVel = var;
	}
	
	// -- Getters -- //
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
	}
	
	// -- Methods -- //
	public void draw(Graphics g) {
		for (int i = bodies.size() - 1; i >= 0; i--) {
			bodies.get(i).draw(g);
		}
	}
	
	public void update(Target t) {
		this.x += this.xVel * this.spd;
		this.y += this.yVel * this.spd;
		
		// X boundaries //
		if (this.x < 0) {
			this.x = 0;
		} else if (x > Game.WIDTH - this.size) {
			this.x = Game.WIDTH - this.size;
		}
		
		// Y boundaries //
		if (this.y < 0) {
			this.y = 0;
		} else if (y > Game.HEIGHT - this.size) {
			this.y = Game.HEIGHT - this.size;
		}
		
		// Update ArrayList<Body> bodies //
		for (int i = bodies.size() - 1; i >= 0; i--) {
			if (i == 0) {
				bodies.get(i).setx(this.x);
				bodies.get(i).sety(this.y);
			} else {
				bodies.get(i).setx(bodies.get(i - 1).getx());
				bodies.get(i).sety(bodies.get(i - 1).gety());
			}
		}
	}
}
