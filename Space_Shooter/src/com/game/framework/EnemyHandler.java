package com.game.framework;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.main.Game;
import com.game.objects.Enemy;
import com.game.objects.Player;

public class EnemyHandler 
{
	public LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	
	private Player player;
	private EnemyBullets eBullets;
	private Random r = new Random();
	
	public EnemyHandler(Player player, EnemyBullets eBullets)
	{
		this.player = player;
		this.eBullets = eBullets;		
	}
	
	public void tick()
	{
		for(int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).tick();
			
			if(!enemies.get(i).getIsAlive())
			{
				enemies.remove(i);
				continue;
			}
			
			if(enemies.get(i).getY() > Game.HEIGHT + 40)
			{
				enemies.remove(i);
				player.setHealth(0);
				Game.gameState = Game.STATE.GameOver;
			}
		}
		
		if(Game.gameState == Game.STATE.GameOver)
		{
			for(int i = 0; i < enemies.size(); i++)
				enemies.remove(i);
		}
		
		switch(player.getScore())
		{
			case -1 :	for(int i = 0, xx = 128; i < 5; i++, xx += 128)
						{
							if(i == 0 || i == 4)
								enemies.add(new Enemy(xx, -68, 0.2f, false, eBullets));
							else if(i == 1 || i == 3)
								enemies.add(new Enemy(xx, -58, 0.2f, false, eBullets));
							else if(i == 2)
								enemies.add(new Enemy(xx, -48, 0.2f, false, eBullets));
						}
			
						player.setScore(0);
			
						break;
		
			case 5 :	for(int i = 0, xx = 96; i < 7; i++, xx += 96)
						{
							if(i == 0 || i == 6)
								enemies.add(new Enemy(xx, -78, 0.27f, r.nextBoolean(), eBullets));
							else if(i == 1 || i == 5)
								enemies.add(new Enemy(xx, -68, 0.27f, r.nextBoolean(), eBullets));
							else if(i == 2 || i == 4)
								enemies.add(new Enemy(xx, -58, 0.27f, r.nextBoolean(), eBullets));
							else if(i == 3)
								enemies.add(new Enemy(xx, -48, 0.27f, r.nextBoolean(), eBullets));
						}
			
						player.setScore(player.getScore() + 2);
						
						break;
						
			case 14 :	for(int i = 0, xx = 96; i < 7; i++, xx += 96)
						{
							if(i == 3)
								enemies.add(new Enemy(xx, -78, 0.32f, r.nextBoolean(), eBullets));
							else if(i == 1 || i == 5)
								enemies.add(new Enemy(xx, -68, 0.32f, r.nextBoolean(), eBullets));
							else if(i == 2 || i == 4)
								enemies.add(new Enemy(xx, -58, 0.32f, r.nextBoolean(), eBullets));
							else if(i == 0 || i == 6)
								enemies.add(new Enemy(xx, -48, 0.32f, r.nextBoolean(), eBullets));
						}
			
						player.setScore(player.getScore() + 3);
						
						break;
						
			case 24 : 	for(int i = 0, xx = 96; i < 7; i++, xx += 96)
						{
							if(i == 3)
								enemies.add(new Enemy(xx, -78, 0.35f, r.nextBoolean(), eBullets));
							else if(i == 2 || i == 4)
								enemies.add(new Enemy(xx, -68, 0.35f, r.nextBoolean(), eBullets));
							else if(i == 1 || i == 5)
								enemies.add(new Enemy(xx, -58, 0.35f, r.nextBoolean(), eBullets));
							else if(i == 0 || i == 6)
								enemies.add(new Enemy(xx, -48, 0.35f, r.nextBoolean(), eBullets));
						}
		
						player.setScore(player.getScore() + 3);
		
						break;
						
			case 34 :	for(int i = 0, xx = 96; i < 7; i++, xx += 96)
						{
							if(i == 3)
								enemies.add(new Enemy(xx, -78, 0.4f, r.nextBoolean(), eBullets));
							else if(i == 1 || i == 5)
								enemies.add(new Enemy(xx, -68, 0.4f, r.nextBoolean(), eBullets));
							else if(i == 2 || i == 4)
								enemies.add(new Enemy(xx, -58, 0.4f, r.nextBoolean(), eBullets));
							else if(i == 0 || i == 6)
								enemies.add(new Enemy(xx, -48, 0.4f, r.nextBoolean(), eBullets));
						}
						player.setScore(player.getScore() + 3);
						
						break;
						
			case 44 :	for(int i = 0, xx = 96; i < 7; i++, xx += 96)
						{
							if(i == 3)
								enemies.add(new Enemy(xx, -78, 0.4f, true, eBullets));
							else if(i == 1 || i == 5)
								enemies.add(new Enemy(xx, -68, 0.4f, true, eBullets));
							else if(i == 2 || i == 4)
								enemies.add(new Enemy(xx, -58, 0.4f, true, eBullets));
							else if(i == 0 || i == 6)
								enemies.add(new Enemy(xx, -48, 0.4f, true, eBullets));
						}
						player.setScore(player.getScore() + 3);
						
						break;
						
			case 55 :	for(int i = 0, xx = 96; i < 7; i++, xx += 96)
						{
							if(i == 3)
								enemies.add(new Enemy(xx, -78, 0.41f, true, eBullets));
							else if(i == 1 || i == 5)
								enemies.add(new Enemy(xx, -68, 0.41f, true, eBullets));
							else if(i == 2 || i == 4)
								enemies.add(new Enemy(xx, -58, 0.41f, true, eBullets));
							else if(i == 0 || i == 6)
								enemies.add(new Enemy(xx, -48, 0.41f, true, eBullets));
						}
						player.setScore(player.getScore() + 3);
						
						break;
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).render(g);			
		}
	}
}
