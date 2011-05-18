package com.bayviewglen.modules;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;

import com.bayviewglen.gameutils.ClipsLoader;
import com.bayviewglen.gameutils.GamePanel;
import com.bayviewglen.vo.Player;
import com.bayviewglen.windows.GameGUI;

public class SampleGameModule extends GamePanel {
	
	private GameGUI parent;
	private ClipsLoader clipsLoader;
	private Player player;
		
	
	public SampleGameModule(GameGUI parentFrame, long period, FileInputStream images, String sounds)	{
		super(images, period);
		
		clipsLoader = new ClipsLoader(sounds);
		
		player = new Player("HERO", PWIDTH, PHEIGHT, imsLoader, period, clipsLoader);		
		parent = parentFrame;
						
		// load the background image	
		setBgImage(imsLoader.getImage("samplebackground"));
		sprites.add(player.getSprite());
	}
	
	// handles termination and game-play keys
	protected void processKeyPressed(KeyEvent e){
			
		super.processKey(e);
		int keyCode = e.getKeyCode();

		// game-play keys
		if (!isPaused() && !isGameOver()) {
			if (keyCode == KeyEvent.VK_LEFT){
				if (!player.isMoving()){
					System.out.println("LEFT Start");
					player.setMoving(true);
					player.moveLeft();
				}
			
			}
			else if (keyCode == KeyEvent.VK_RIGHT){
				if (!player.isMoving()){
					player.setMoving(true);
					player.moveRight();
				}
			}else if (keyCode == KeyEvent.VK_A){
						player.attack(1);
			}else if (keyCode == KeyEvent.VK_Z){
						player.attack(2);
			}
		}
	}
	
	// handles termination and game-play keys
	protected void processKeyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();

		// game-play keys
		if (!isPaused() && !isGameOver()) {
			if (keyCode == KeyEvent.VK_LEFT)
				player.stayStill();
			else if (keyCode == KeyEvent.VK_RIGHT)
				player.stayStill();
			
		}
	}
}
