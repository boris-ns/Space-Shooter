package com.game.framework;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.objects.Bullet;

public class Bullets 
{
	public LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	
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
