package com.game.objects;

import java.awt.Graphics;
import java.util.LinkedList;

public class Bullets 
{
	private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	
	public void tick()
	{
		for(int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).tick();
			
			if(bullets.get(i).getY() <= -10)
				bullets.remove(i);
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < bullets.size(); i++)
			bullets.get(i).render(g);
	}
	
	public void addBullet(Bullet bullet)
	{
		bullets.add(bullet);
	}
}
