package com.game.graphics;

import java.awt.image.BufferedImage;

public class Texture 
{
	SpriteSheet ss = null;

	public BufferedImage player;
	public BufferedImage star;
	public BufferedImage enemy;
	private BufferedImage spriteSheet;
	
	public Texture()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		
		spriteSheet = loader.loadImage("/SpriteSheet.png");
		
		ss = new SpriteSheet(spriteSheet);
		
		getTextures();
	}
	
	private void getTextures()
	{
		player = ss.grabImage(1, 1, 48, 48);
		star = ss.grabImage(2, 1, 48, 48);
		enemy = ss.grabImage(3,  1, 48, 48);
	}
}
