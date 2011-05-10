/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;

/**
 * @author kdeslauriers
 *
 */
public abstract class Item implements Serializable{

	int xPosition, yPosition;
	int xSize, ySize;
	
	public Item (int width, int height){
		setxPosition(0);
		setyPosition(0);
		setxSize(width);
		setySize(height);
	}
	
	public Item (int width, int height, int xPos, int yPos){
		setxPosition(xPos);
		setyPosition(yPos);
		setxSize(width);
		setySize(height);
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
}
