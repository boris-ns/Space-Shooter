package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.game.framework.Bullets;
import com.game.framework.CollisionHandler;
import com.game.framework.EnemyBullets;
import com.game.framework.EnemyHandler;
import com.game.framework.Stars;
import com.game.graphics.Texture;
import com.game.graphics.Window;
import com.game.input.KeyInput;
import com.game.objects.Hud;
import com.game.objects.ObjectId;
import com.game.objects.Player;

public class Game extends Canvas implements Runnable
{
	public static final int WIDTH = 800, HEIGHT = 550;
	public static Texture tex = new Texture();
	public static enum STATE { Menu, Game, Help, GameOver};
	public static STATE gameState = STATE.Menu;
	
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private Player player;
	private KeyInput keyInput;
	private Stars stars;
	private Bullets bullets;
	private EnemyBullets eBullets;
	private EnemyHandler enemyHandler;
	private Hud hud;
	private CollisionHandler collisionHandler;
	private Menu menu;
	private GameOverMenu gameOver;
	
	public Game()
	{
		new Window(WIDTH, HEIGHT, "Space Shooter", this);
		menu = new Menu();
		gameOver = new GameOverMenu();
		
		bullets = new Bullets();
		player = new Player(WIDTH / 2 - 32, ObjectId.Player, bullets);
		
		keyInput = new KeyInput(player);
		addKeyListener(keyInput);
				
		eBullets = new EnemyBullets();
		stars = new Stars();		
		enemyHandler = new EnemyHandler(player, eBullets);
		hud = new Hud(player);
		collisionHandler = new CollisionHandler(player, enemyHandler, bullets, eBullets);
	}
	
	public void tick()
	{
		keyInput.tick();
		stars.tick();
		
		if(gameState == STATE.Menu)
			menu.tick();
		else if(gameState == STATE.Game)
		{
			bullets.tick();
			eBullets.tick();
			enemyHandler.tick();
			player.tick();
			collisionHandler.tick();
			hud.tick();
		}
		else if(gameState == STATE.GameOver)
		{
			gameOver.tick(player.getScore());
			eBullets.tick();
			bullets.tick();
			enemyHandler.tick();
		}
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
		
		stars.render(g);
		
		if(gameState == STATE.Menu || gameState == STATE.Help)
			menu.render(g);
		else if(gameState == STATE.Game)
		{
			bullets.render(g);
			eBullets.render(g);
			enemyHandler.render(g);
			player.render(g);
			hud.render(g);
		}
		else if(gameState == STATE.GameOver)
			gameOver.render(g);
			
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
