package com.bayviewglen.game;

import com.bayviewglen.gameutils.ClipsLoader;
import com.bayviewglen.gameutils.Direction;
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

	private ClipsLoader clipsLoader;
	
	private int period;
	/* in ms. The game's animation period used by the image
      cycling of the bat's left and right facing images. */

	// Initialise the Character Sprite
	public CharacterSprite(int w, int h, ImagesLoader imsLd, int p, ClipsLoader clipsLoader){ 
		super( w/2, h-FLOOR_DIST, w, h, imsLd, "walkingeast"); 
		this.clipsLoader = clipsLoader;
		period = p;
		setStep(0,0);  // no movement
	}
	
	//Begin an attack sequence for the character.
	public void attack(int orientation){
				
		if (orientation == 1){
			setImage("attacklow" + getDirectionString());
			clipsLoader.play("hitRight", false);
		}else if(orientation == 2){
			setImage("attackhigh" + getDirectionString());
		}
			
		loopImage(period, DURATION, false);   // cycle through the leftBugs2 images
	}

	// start the Character moving left
	public void moveLeft(){ 
		setStep(-XSTEP, 0);
		setDirection(Direction.WEST);
		setImage("walking" + getDirectionString());
		loopImage(period, DURATION);   // cycle through the leftBugs2 images
	}

	// start the Character moving right
	public void moveRight(){ 
		setStep(XSTEP, 0); 
		setDirection(Direction.EAST);
		setImage("walking" + getDirectionString());
		loopImage(period, DURATION);  // cycle through the images
	}


	// stop the character from moving
	public void stayStill(){
		setStep(0, 0); 
		stopLooping();
		setMoving(false);
	}

	private String getDirectionString() {
		return Direction.getDirectionString(getDirection());
	}
	
	// have the character wrap-around at the walls
	public void updateSprite(){
		if ((locx+getWidth() <= 0) && (dx < 0))   // almost gone off lhs
			locx = getPWidth()-1;      // make it just visible on the right
		else if ((locx >= getPWidth()-1) && (dx > 0))  // almost gone off rhs
			locx = 1 - getWidth();     // make it just visible on the left

		super.updateSprite();
	}
} 
