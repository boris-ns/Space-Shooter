package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.game.input.KeyInput;
import com.game.main.Game;

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
		velX = 0;
	}
	
	public void tick()
	{
		x += velX;
		
		if(x <= 5) x = 5;
		if(x >= Game.WIDTH - (width + 13)) x = Game.WIDTH - (width + 13); 
		
		if(KeyInput.left)
			velX = -8f;		
		else if(KeyInput.right)
			velX = 8;
		else
			velX = 0;
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
