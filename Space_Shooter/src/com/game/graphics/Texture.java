package com.game.graphics;

import java.awt.image.BufferedImage;

import com.game.objects.Player;

public class Texture 
{
	SpriteSheet ss = null;

	public BufferedImage[] player = new BufferedImage[1];
	public BufferedImage star = null;
	public BufferedImage enemy = null;
	private BufferedImage spriteSheet = null;
	
	public Texture()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		
		spriteSheet = loader.loadImage("/SpriteSheet.png");
		
		ss = new SpriteSheet(spriteSheet);
		
		getTextures();
	}
	
	private void getTextures()
	{
		player[0] = ss.grabImage(1, 1, 48, 48);
		star = ss.grabImage(2, 1, 48, 48);
		enemy = ss.grabImage(3,  1, 48, 48);
	}
}
