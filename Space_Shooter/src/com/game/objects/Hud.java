package com.game.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Hud 
{
	private Player player;
	
	public Hud(Player player)
	{
		this.player = player;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(15, 15, player.getHealth(), 7);
		
		Font font = new Font("Arial", 1, 15);
		g.setFont(font);
		g.drawString("Score " + player.getScore(), 15, 40);
	}
}
