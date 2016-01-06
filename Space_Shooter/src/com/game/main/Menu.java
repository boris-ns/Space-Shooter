package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.input.KeyInput;

public class Menu 
{		
	public static enum STATE { Play, Help, Quit};
	public static STATE menuState = STATE.Play;
	
	private boolean play;
	private boolean help;
	private boolean quit;

	public void tick()
	{
			play = menuState == STATE.Play;
			help = menuState == STATE.Help;
			quit = menuState == STATE.Quit;	
	
			if(play && KeyInput.menuEnter)
				Game.gameState = Game.STATE.Game;
			else if(quit && KeyInput.menuEnter)
				System.exit(-1);
	}
	
	public void render(Graphics g)
	{
		Font font = new Font("Impact", 1, 32);
		g.setFont(font);
		g.setColor(Color.GREEN);
		
		if(Game.gameState == Game.STATE.Menu)
		{
			if(play)
			{
				g.drawString(">Play", 100, 400);
				g.drawString("Help/About", 100, 430);
				g.drawString("Quit", 100, 460);
			}
			else if(help)
			{
				g.drawString("Play", 100, 400);
				g.drawString(">Help/About", 100, 430);
				g.drawString("Quit", 100, 460);
			}
			else if(quit)
			{
				g.drawString("Play", 100, 400);
				g.drawString("Help/About", 100, 430);
				g.drawString(">Quit", 100, 460);
			}
		}
		else if(Game.gameState == Game.STATE.Help)
		{
			g.drawString("Game made by Boris Sulicenko, 2016.", 100, 400);
			g.drawString("Controls:", 100, 430);
			g.drawString("Left/Right arrows or A/D and SPACE", 100, 460);
			g.drawString("Press ENTER to go back", 100, 490);
		}
	}
}
