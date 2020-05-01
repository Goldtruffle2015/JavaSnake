package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	// -- Attributes -- //
	private Player p;
	
	// -- Constructor -- //
	public KeyInput(Player p) {
		this.p = p;
	}
	
	// -- Methods -- //
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		// Key Events //
		if (key == KeyEvent.VK_UP && p.getyVel() == 0) {
			p.setxVel(0);
			p.setyVel(-1);
		}
		
		if (key == KeyEvent.VK_DOWN && p.getyVel() == 0) {
			p.setxVel(0);
			p.setyVel(1);
		}
		
		if (key == KeyEvent.VK_LEFT && p.getxVel() == 0) {
			p.setxVel(-1);
			p.setyVel(0);
		}
		
		if (key == KeyEvent.VK_RIGHT && p.getxVel() == 0) {
			p.setxVel(1);
			p.setyVel(0);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}
