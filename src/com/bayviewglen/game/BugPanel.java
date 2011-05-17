
package com.bayviewglen.game;

// BugPanel.java
// Andrew Davison, April 2005, ad@fivedots.coe.psu.ac.th

/* The game's drawing surface. Uses active rendering to a JPanel
   with the help of Java 3D's timer.
   See WormP for a version with statistics generation.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;

import com.bayviewglen.gameutils.ClipsLoader;
import com.bayviewglen.gameutils.GamePanel;
import com.bayviewglen.windows.BugRunner;


public class BugPanel extends GamePanel{

	private BugRunner bugTop;
	
	private BallSprite ball;        // the sprites
	private BatSprite bat;
	

	private ClipsLoader clipsLoader;
	
	public BugPanel(BugRunner br, long period, FileInputStream images, String sounds)	{
	
		super(images);
	    clipsLoader = new ClipsLoader(sounds); 

		bugTop = br;
		this.setPeriod(period);

		setDoubleBuffered(false);
		setBackground(Color.black);
		setPreferredSize( new Dimension(PWIDTH, PHEIGHT));

		setFocusable(true);
		requestFocus();    // the JPanel now has focus, so receives key events

		addKeyListener( new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				processKeyPressed(e);
			}
		});
		
		addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				processKeyReleased(e);
			}
		});

		// load the background image	
		setBgImage(imsLoader.getImage("bladerunner"));

		// create game sprites
		bat = new BatSprite(PWIDTH, PHEIGHT, imsLoader, (int)(period/1000000L) ); // in ms
		ball = new BallSprite(PWIDTH, PHEIGHT, imsLoader, clipsLoader, this, bat); 

		sprites.add(bat);
		sprites.add(ball);

		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				testPress(e.getX()); 
			}  // handle mouse presses
		});

	}

	protected void processKeyPressed(KeyEvent e)
	// handles termination and game-play keys
	{
		super.processKey(e);
		int keyCode = e.getKeyCode();

		// game-play keys
		if (!isPaused() && !isGameOver()) {
			if (keyCode == KeyEvent.VK_LEFT){
				if (!bat.isMoving()){
					bat.setMoving(true);
					bat.moveLeft();
				}
			}
			else if (keyCode == KeyEvent.VK_RIGHT)
				if (!bat.isMoving()){
					bat.setMoving(true);
					bat.moveRight();
				}
			
		}
	}  // end of processKey()
	
	protected void processKeyReleased(KeyEvent e)
	// handles termination and game-play keys
	{
//		super.processKey(e);
		int keyCode = e.getKeyCode();

		// game-play keys
		if (!isPaused() && !isGameOver()) {
			if (keyCode == KeyEvent.VK_LEFT)
				bat.stayStill();
			else if (keyCode == KeyEvent.VK_RIGHT)
				bat.stayStill();

		}
	}  // end of processKey()


}  // end of BugPanel class
