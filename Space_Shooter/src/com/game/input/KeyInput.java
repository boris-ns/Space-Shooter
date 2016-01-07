package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.main.Game;
import com.game.main.Menu;
import com.game.objects.Player;

public class KeyInput implements KeyListener
{
	public static boolean left, right, fire, exit, menuUp, menuDown, menuEnter;

	private boolean[] keyboard = new boolean[150];
	private Player player;
	
	public KeyInput(Player player)
	{
		this.player = player;
	}
	
	public void tick()
	{
		left = keyboard[KeyEvent.VK_LEFT] || keyboard[KeyEvent.VK_A];
		right = keyboard[KeyEvent.VK_RIGHT] || keyboard[KeyEvent.VK_D];
		exit = keyboard[KeyEvent.VK_ESCAPE];
		fire = keyboard[KeyEvent.VK_SPACE];
		
		if((Game.gameState == Game.STATE.Game || Game.gameState == Game.STATE.GameOver) && exit)
			System.exit(-1);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keyboard[e.getKeyCode()] = true;

		menuUp = keyboard[KeyEvent.VK_UP];
		menuDown = keyboard[KeyEvent.VK_DOWN];
		menuEnter = keyboard[KeyEvent.VK_ENTER];
		
		if(Game.gameState == Game.STATE.Menu)
		{			
			if(Menu.menuState == Menu.STATE.Play && menuDown)
				Menu.menuState = Menu.STATE.Help;
			else if(Menu.menuState == Menu.STATE.Help && menuDown)
				Menu.menuState = Menu.STATE.Quit;
			else if(Menu.menuState == Menu.STATE.Quit && menuDown)
				Menu.menuState = Menu.STATE.Play;
			
			if(Menu.menuState == Menu.STATE.Play && menuUp)
				Menu.menuState = Menu.STATE.Quit;
			else if(Menu.menuState == Menu.STATE.Help && menuUp)
				Menu.menuState = Menu.STATE.Play;
			else if(Menu.menuState == Menu.STATE.Quit && menuUp)
				Menu.menuState = Menu.STATE.Help;
			
			if(Menu.menuState == Menu.STATE.Help && menuEnter)
				Game.gameState = Game.STATE.Help;
		}
		else if(Game.gameState == Game.STATE.Help && menuEnter)
			Game.gameState = Game.STATE.Menu;
		else if(Game.gameState == Game.STATE.GameOver && menuEnter)
		{
			Game.gameState = Game.STATE.Game;
			player.setScore(-1);
		}
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
