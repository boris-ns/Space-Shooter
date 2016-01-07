package com.game.objects;

import java.awt.Graphics;
import java.util.Random;

import com.game.main.Game;

public class Star 
{
	private float x, y, velY;
	private int width = 8; // width and height are equal
	private ObjectId id;
	private Random random = new Random();
	
	public Star()
	{
		x = 10 + random.nextInt(Game.WIDTH - 15);
		y = 10 + random.nextInt(Game.HEIGHT - 15);
	
		velY = 4;
	}
	
	public void tick()
	{
		y += velY;
	
		if(y >= Game.HEIGHT + width)
		{
			y = 0 - width;
			x = 10 + random.nextInt(Game.WIDTH - 15);
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Game.tex.star, (int)x, (int)y, width, width, null);
	}
	
	public float getY() { return y;}
	public void setX(float x) { this.x = x;}
	public void setY(float y) { this.y = y;}
}
