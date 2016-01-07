package com.game.framework;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.main.Game;
import com.game.objects.EnemyBullet;

public class EnemyBullets 
{
	public LinkedList<EnemyBullet> eBullets = new LinkedList<EnemyBullet>();
	
	public void tick()
	{
		for(int i = 0; i < eBullets.size(); i++)
		{
			eBullets.get(i).tick();
			
			if(eBullets.get(i).getY() > Game.HEIGHT + 10)
				eBullets.remove(i);
		}
		
		if(Game.gameState == Game.STATE.GameOver)
		{
			for(int i = 0; i < eBullets.size(); i++)
				eBullets.remove(i);
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < eBullets.size(); i++)
			eBullets.get(i).render(g);
	}
	
	public void addBullet(EnemyBullet bullet)
	{
		eBullets.add(bullet);
	}
}
