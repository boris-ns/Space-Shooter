package com.game.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.framework.Bullets;
import com.game.framework.EnemyBullets;
import com.game.main.Game;

public class Enemy 
{
	private float x, y, velX, velY;
	private ObjectId id;
	private int width = 32; // width and height are equal
	private float health = 100;
	private boolean canShoot, isAlive;
	private EnemyBullets eBullets;
	private Random r = new Random();
	private int timer = r.nextInt(200);
	
	public Enemy(float x, float y, float velY, boolean canShoot, EnemyBullets eBullets)
	{
		this.x = x;
		this.y = y;
		this.id = ObjectId.Enemy;
		this.canShoot = canShoot;
		this.isAlive = true;
		this.velY = velY;
		this.eBullets = eBullets;
	}
	
	public void tick()
	{
		y += velY;
		--timer;
		
		if(canShoot && timer == 0)
		{
			eBullets.addBullet(new EnemyBullet((int)x + 10, (int)y, 3.5f));
			timer = r.nextInt(200) + 50;
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Game.tex.enemy, (int)x, (int)y, 32, 32, null);
		
		Font font = new Font("Arial", 1, 12);
		g.setFont(font);
		g.setColor(Color.green);
		g.drawString("<" + health + ">", (int)x - 5, (int)y - 10);
	}
	
	public float getY() { return y;}
	public float getHealth() { return health;}
	public boolean getCanShoot() { return canShoot;}
	public boolean getIsAlive() { return isAlive;}
	
	public void setHealth(float health) { this.health = health;}
	public void setCanShoot(boolean canShoot) { this.canShoot = canShoot;}
	public void setIsAlive(boolean isAlive) { this.isAlive = isAlive;}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y + 25, width, width - 25);
	}
}
