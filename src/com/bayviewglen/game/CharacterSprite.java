package com.bayviewglen.game;

import com.bayviewglen.gameutils.ImagesLoader;
import com.bayviewglen.gameutils.Sprite;

public class CharacterSprite extends Sprite{
	
	private static double DURATION = 0.5;  // secs
	// total time to cycle through all the images

	private static final int FLOOR_DIST = 100;   
	// distance of ant's top from the floor
	
	private static final int XSTEP = 10;   
	// step distance for moving along x-axis

	private static final int YSTEP = 10;   
	// step distance for moving along y-axis

	
	private int period;
	/* in ms. The game's animation period used by the image
      cycling of the bat's left and right facing images. */

	// Initialise the Character Sprite
	public CharacterSprite(int w, int h, ImagesLoader imsLd, int p){ 
		super( w/2, h-FLOOR_DIST, w, h, imsLd, "walkingleft"); 
		period = p;
		setStep(0,0);  // no movement
	}
	
	//Begin an attack sequence for the character.
	public void attack(int orientation){
		if (orientation == 1){
			setImage("attacklow");
		}else if(orientation == 2){
			setImage("attackhigh");
		}
			
		loopImage(period, DURATION, false);   // cycle through the leftBugs2 images
	}

	// start the Character moving left
	public void moveLeft(){ 
		setStep(-XSTEP, 0);
		setImage("walkingleft");
		loopImage(period, DURATION);   // cycle through the leftBugs2 images
	}

	// start the Character moving right
	public void moveRight(){ 
		setStep(XSTEP, 0); 
		setImage("walkingright");
		loopImage(period, DURATION);  // cycle through the images
	}

	// stop the character from moving
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
} 
