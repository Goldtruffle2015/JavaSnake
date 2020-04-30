// Title: Snake
// Author: John Yu
// Date: 2020-04-30

package com.main;

import javax.swing.JFrame;

public class Window {
	public Window(String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button exits window
		frame.setResizable(false); // User cannot resize window
		frame.add(game); 
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
}