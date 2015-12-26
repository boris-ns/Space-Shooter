package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.game.graphics.Texture;
import com.game.input.KeyInput;
import com.game.main.Game;

public class Player 
{
	public static final int width = 48; // Width and height are equal
	private float x, velX;
	private final float y;
	private ObjectId id;
	private Bullets bullets;
	
	public Player(float x, ObjectId id, Bullets bullets)
	{
		this.x = x;
		this.y = 450;
		this.id = id;
		velX = 0;
		this.bullets = bullets;
	}
	
	public void tick()
	{
		x += velX;
		
		if(x <= 5) x = 5;
		if(x >= Game.WIDTH - (width + 13)) x = Game.WIDTH - (width + 13); 
		
		if(KeyInput.fire)
		{
			bullets.addBullet(new Bullet(x + 1, y - 5, -5));
			bullets.addBullet(new Bullet(x + width - 4, y - 5, -5));
		}
		
		if(KeyInput.left)
			velX = -8f;		
		else if(KeyInput.right)
			velX = 8;
		else
			velX = 0;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Game.tex.player[0], (int)x, (int)y, null);
	}
	
	public float getX() { return x;}
	public float getVelX() { return velX;}
	public ObjectId getId() { return id;}
	public void setX(float x) {	this.x = x;}
	public void setVelX(float velX) { this.velX = velX;}
}
