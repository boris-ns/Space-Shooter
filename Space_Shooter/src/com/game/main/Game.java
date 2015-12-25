package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.game.graphics.Window;
import com.game.input.KeyInput;
import com.game.objects.ObjectId;
import com.game.objects.Player;

public class Game extends Canvas implements Runnable
{
	public static final int WIDTH = 800, HEIGHT = 550;
	
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private Player player;
	private KeyInput keyInput;


	public Game()
	{
		new Window(WIDTH, HEIGHT, "Space Shooter", this);
		keyInput = new KeyInput();
		addKeyListener(keyInput);
		
		player = new Player(WIDTH / 2 - 32, ObjectId.Player);
	}
	
	public void tick()
	{
		player.tick();
		keyInput.tick();
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;	
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		player.render(g);
		
		g.dispose();
		bs.show();
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
	
	@Override
	public void run() 
	{
		this.requestFocus();
		
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
