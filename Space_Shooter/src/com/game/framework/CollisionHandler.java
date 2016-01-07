package com.game.framework;

import com.game.objects.Player;

public class CollisionHandler 
{
	private Player player;
	private EnemyHandler enemies;
	private Bullets bullets;
	private EnemyBullets eBullets;
	
	public CollisionHandler(Player player, EnemyHandler enemies, Bullets bullets, EnemyBullets eBullets)
	{
		this.player = player;
		this.enemies = enemies;
		this.bullets = bullets;
		this.eBullets = eBullets;
	}
	
	public void tick()
	{
		// Enemies - bullets collision
		for(int i = 0; i < enemies.enemies.size(); i++)
		{
			for(int j = 0; j < bullets.bullets.size(); j++)
			{	
				if(enemies.enemies.get(i).getBounds().intersects(bullets.bullets.get(j).getBounds()))
				{
					enemies.enemies.get(i).setHealth(enemies.enemies.get(i).getHealth() - 1f);	
					bullets.bullets.remove(j);
					
					if(enemies.enemies.get(i).getHealth() == 0)
					{
						enemies.enemies.get(i).setIsAlive(false);
						player.setScore(player.getScore() + 1);
					}
				}				
			}
			
			// Enemies - player collision
			if(enemies.enemies.get(i).getBounds().intersects(player.getBounds()))
			{
				player.setHealth(0);
			}
		}
		
		// EnemyBullets - Player collision
		for(int i = 0; i < eBullets.eBullets.size(); i++)
		{
			if(eBullets.eBullets.get(i).getBounds().intersects(player.getBounds()))
			{
				player.setHealth(player.getHealth() - 10);
				eBullets.eBullets.remove(i);
			}
		}
	}
}
