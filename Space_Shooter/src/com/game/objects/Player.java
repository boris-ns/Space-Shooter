package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
	private float x, velX;
	private final float y;
	private final int width = 32; // Width and height are equal
	private ObjectId id;
	
	public Player(float x, ObjectId id)
	{
		this.x = x;
		this.y = 450;
		this.id = id;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)width);
	}
	
	public float getX() { return x;}
	public float getVelX() { return velX;}
	public ObjectId getId() { return id;}
	public void setX(float x) {	this.x = x;}
	public void setVelX(float velX) { this.velX = velX;}
}
