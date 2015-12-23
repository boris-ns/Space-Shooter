package com.game.main;

import java.awt.Canvas;

import com.game.graphics.Window;

public class Game extends Canvas implements Runnable
{
	public final int WIDTH = 800, HEIGHT = 550;
	
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;


	public Game()
	{
		new Window(WIDTH, HEIGHT, "Space Shooter", this);
	}
	
	public void tick()
	{
		
	}
	
	public void render()
	{
		
	}

	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try 
		{
			thread.join();
			running = false;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void run() 
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	
	public static void main(String[] args)
	{
		new Game();
	}
}
