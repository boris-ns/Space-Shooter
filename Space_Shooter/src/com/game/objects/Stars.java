package com.game.objects;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.main.Game;

public class Stars 
{
	private LinkedList<Star> stars = new LinkedList<Star>();
	
	public Stars()
	{
		for(int i = 0; i < 30; i++)
			stars.add(new Star());

	}
	
	public void tick()
	{		
		for(int i = 0; i < stars.size(); i++)
			stars.get(i).tick();

	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < stars.size(); i++)
			stars.get(i).render(g);
	}
}
