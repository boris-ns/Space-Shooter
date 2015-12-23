package com.game.graphics;

import java.awt.Dimension;
import javax.swing.JFrame;
import com.game.main.Game;

public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Game game)
	{		
		this.setTitle(title);
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(game);
		this.setVisible(true);
		
		game.start();
	}
}
