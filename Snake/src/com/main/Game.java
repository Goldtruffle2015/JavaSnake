// Title: Snake
// Author: John Yu
// Date: 2020-04-30

package com.main;

import java.awt.Canvas;
import java.awt.Dimension;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -668240625892092763L;

	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH *9/16;
	
	public boolean running = false;
	private Thread gameThread;
	
	private Player player;
	private Target target;
	
	public Game() {
		// -- Setup canvas -- //
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
		// -- Create the window -- //
		new Window("Snake by John Yu", this);
	}

	@Override
	public void run() {
		
	}

	public void start() {
		
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
