package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet 
{
	private final float x;
	private float y, velY;
	private ObjectId id;
	private int width = 2, height = 4;
	private Color color = new Color(204, 0, 27);
	
	public Bullet(float x, float y, float velY)
	{
		this.x = x;
		this.y = y;
		this.velY = velY;
		this.id = ObjectId.Bullet;
	}
	
	public void tick()
	{
		y += velY;
	}
	
	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public float getY() { return y;}
}
