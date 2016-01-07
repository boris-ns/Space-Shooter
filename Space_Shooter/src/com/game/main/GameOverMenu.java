package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOverMenu 
{
	private int playerScore;
	
	public void tick(int playerScore)
	{
		this.playerScore = playerScore;
	}
	
	public void render(Graphics g)
	{
		Font font = new Font("Impact", 1, 32);
		g.setFont(font);
		g.setColor(Color.GREEN);
		
		g.drawString("Game over", 325, 200);
		g.drawString("Your score: " + playerScore, 310, 250);
		g.drawString("Press ENTER to play again or ESC to exit.", 110, 300);
	}
}
