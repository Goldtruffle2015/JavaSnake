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
	
	public int getxVel() {
		return this.xVel;
	}
	
	public int getyVel() {
		return this.yVel;
	}
	
	public ArrayList<Body> getBodies() {
		return this.bodies;
	}
	
	// -- Methods -- //
	public void draw(Graphics g) {
		for (int i = this.bodies.size() - 1; i >= 0; i--) {
			this.bodies.get(i).draw(g);
		}
	}
	
	public void update(Target t) {
		
		this.x += this.xVel * this.spd;
		this.y += this.yVel * this.spd;
		
		// Boundaries //
		if (this.x < 0 || x > Game.WIDTH - this.size || this.y < 0 || y > Game.HEIGHT - this.size) {	// When snake moves out of bounds
			System.exit(0);	// Game ends. System terminates as placeholder
		}
		
		// Hit Target //
		if (this.x == t.getx() && this.y == t.gety()) {
			this.bodies.add(new Body(this.color, 0, 0));	// Adds a new body at an arbitrary location
		}
		
		// Update ArrayList<Body> bodies //
		for (int i = this.bodies.size() - 1; i >= 0; i--) {
			if (i == 0) {
				this.bodies.get(i).setx(this.x);
				this.bodies.get(i).sety(this.y);
			} else {
				this.bodies.get(i).setx(this.bodies.get(i - 1).getx());
				this.bodies.get(i).sety(this.bodies.get(i - 1).gety());
			}
		}
		
		// Check if snake hit itself //
		for (int i = this.bodies.size() - 1; i > 0; i--) {
			if (this.bodies.get(0).getx() == this.bodies.get(i).getx() && this.bodies.get(0).gety() == this.bodies.get(i).gety()) {	// If snake overlaps itself
				System.exit(0);	// System terminates as placeholder
			}
		}
	}
}
