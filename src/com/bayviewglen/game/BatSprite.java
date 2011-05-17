package com.bayviewglen.game;

import com.bayviewglen.gameutils.ImagesLoader;
import com.bayviewglen.gameutils.Sprite;

public class BatSprite extends Sprite{
	private static double DURATION = 0.5;  // secs
	// total time to cycle through all the images

	private static final int FLOOR_DIST = 41;   
	// distance of ant's top from the floor
	
	private static final int XSTEP = 10;   
	// step distance for moving along x-axis


	private int period;
	/* in ms. The game's animation period used by the image
      cycling of the bat's left and right facing images. */


	public BatSprite(int w, int h, ImagesLoader imsLd, int p){ 
		super( w/2, h-FLOOR_DIST, w, h, imsLd, "leftBugs2"); 
		period = p;
		setStep(0,0);  // no movement
	}

	// start the ant moving left
	public void moveLeft(){ 
		setStep(-XSTEP, 0);
		setImage("leftBugs2");
		loopImage(period, DURATION);   // cycle through the leftBugs2 images
	}

	// start the ant moving right
	public void moveRight(){ 
		setStep(XSTEP, 0); 
		setImage("rightBugs2");
		loopImage(period, DURATION);  // cycle through the images
	}

	// stop the ant moving
	public void stayStill(){
		setStep(0, 0); 
		stopLooping();
		setMoving(false);
	}

	// have the bat wrap-around at the walls
	public void updateSprite(){
		if ((locx+getWidth() <= 0) && (dx < 0))   // almost gone off lhs
			locx = getPWidth()-1;      // make it just visible on the right
		else if ((locx >= getPWidth()-1) && (dx > 0))  // almost gone off rhs
			locx = 1 - getWidth();     // make it just visible on the left

		super.updateSprite();
	}


	// start the ant moving based on a mouse click
	public void mouseMove(int xCoord){
		if (xCoord < locx)  // click was to the left of the bat
			moveLeft();       // make the bat move left
		else if (xCoord > (locx + getWidth()))  // click was to the right of the bat
			moveRight();      // make the bat move right
		else
			stayStill();
	}

} 
