package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBullet 
{
	private final float x;
	private float y, velY;
	private ObjectId id;
	private int width = 10, height = 10;
	private Color color = new Color(255, 0, 0);
	
	public EnemyBullet(float x, float y, float velY)
	{
		this.x = x;
		this.y = y;
		this.velY = velY;
		this.id = ObjectId.EnemyBullet;
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
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, width, height);
	}
}
