// Title: Snake
// Author: John Yu
// Date: 2020-04-30

package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	// -- Attributes -- //
	private static final long serialVersionUID = -668240625892092763L;	// No idea what this is for

	// Screen Dimensions //
	public static final int WIDTH = 1152;	// Sets window width to screen width
	public static final int HEIGHT = 648;	// Sets window height to screen height
	
	// Threading //
	public boolean running = false;	// Define whether the game is running or not
	private Thread gameThread;	// Creates a thread variable for game thread
	
	// Instances //
	private Player player;	// Creates a variable for the player sprite
	private Target target;	// Creates a variable for the target sprite
	
	// -- Constructor Method -- //
	public Game() {
		setUpCanvas();	// Set up the canvas
		initialize();	// Initialize the player and target classes
		
		// -- Create the window -- //
		new Window("Snake by John Yu", this);
	}
	
	// -- Functions -- //
	
	private void initialize() {
		// Initialize player
		player = new Player(Color.white);	// Creates a white snake
		
		// Initialize target
		target = new Target(Color.white);	// Creates a white target
	}
	
	public void setUpCanvas() {	// Sets the preferred dimensions of the canvas
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	}
	
	// -- Methods -- //
	@Override
	public void run() {	// Runs the game
		this.requestFocus();
		// game timer
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		// Looping starts here //
		while (running) {	
			long now = System.nanoTime();
			delta +=(now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();	// Updates the sprites
				delta--;
			}
			if (running) draw();	// Draws the updated sprites
			frames++;
			
			if (System.currentTimeMillis() - timer < 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void draw() {
		// Initialize drawing tools //
		BufferStrategy buffer = this.getBufferStrategy();
		
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		// Draw background //
		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// Draw Player //
		player.draw(g);
		
		// Draw Target //
		target.draw(g);
		
		// Dispose, ACTUALLY draw //
		g.dispose();
		buffer.show();
	}

	private void update() {
		// Player //
		
		// Target //
	}

	public void start() {
		gameThread = new Thread(this);	// Creates a new game thread
		gameThread.start();  // Starts the game thread
		running = true;  // Runs the game
	}
	
	private void stop() {
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// -- Main Method -- //
	public static void main(String[] args) {	 
		new Game();
	}
}
