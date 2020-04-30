//	The window class handles the main frame of the game
//	This is where the entire game happens
//

package com.main;

import javax.swing.JFrame;

public class Window {
	public Window(String title, Game game) {
		JFrame frame = new JFrame(title);	// Creates the raw window
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button exits window
		frame.setResizable(false); // User cannot resize window
		frame.add(game);	// Game class is a component of the frame
		frame.pack();	// Components of frame will fit onto window
		frame.setLocationRelativeTo(null);	// Game will be centered in window
		frame.setVisible(true);
		
		game.start();
	}
}