package com.game.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.framework.Bullets;
import com.game.input.KeyInput;
import com.game.main.Game;

public class Player 
{
	public static final int width = 48; // Width and height are equal
	private float x, velX;
	private final float y;
	private ObjectId id;
	private int health;
	private Bullets bullets;
	private int score;
	
	public Player(float x, ObjectId id, Bullets bullets)
	{
		this.x = x;
		this.y = 450;
		this.id = id;
		velX = 0;
		this.bullets = bullets;
		health = 100;
		score = -1;
	}
	
	public void tick()
	{
		x += velX;
		
		if(x <= 5) x = 5;
		if(x >= Game.WIDTH - (width + 13)) x = Game.WIDTH - (width + 13); 
		
		if(health == 0 )
		{
			Game.gameState = Game.STATE.GameOver;
			health = 100;
			x = Game.WIDTH / 2 - 32;
		}
		
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
		g.drawImage(Game.tex.player, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, width, width);
	}
	
	public float getX() { return x;}
	public float getVelX() { return velX;}
	public ObjectId getId() { return id;}
	public int getHealth() { return health;}
	public int getScore() { return score;}
	public void setX(float x) {	this.x = x;}
	public void setVelX(float velX) { this.velX = velX;}
	public void setHealth(int health) { this.health = health;}
	public void setScore(int score) { this.score = score;}
}
