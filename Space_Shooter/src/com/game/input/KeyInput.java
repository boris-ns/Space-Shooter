package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{
	private boolean[] keyboard = new boolean[120];
	private boolean left, right, fire, exit;
	
	public void tick()
	{
		left = keyboard[KeyEvent.VK_LEFT] || keyboard[KeyEvent.VK_A];
		right = keyboard[KeyEvent.VK_RIGHT] || keyboard[KeyEvent.VK_D];
		fire = keyboard[KeyEvent.VK_SPACE];
		exit = keyboard[KeyEvent.VK_ESCAPE];
		
		if(exit)
			System.exit(-1);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keyboard[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keyboard[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{		
	}
	
}