package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Body {
	// -- Attributes -- //
	private Color color;	// Stores the color of the body
	private int x, y;	// Stores the position of the body
	private int size = 36;	// Defines the size of the body
	
	// -- Constructor -- //
	public Body(Color c, int x, int y) {
		this.color = c;
		this.x = x;
		this.y = y;
	}
	
	// -- Setter -- //
	public void setx(int x) {
		this.x = x;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
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
		g.fillRect(this.x, this.y, this.size, this.size);
	}
}
