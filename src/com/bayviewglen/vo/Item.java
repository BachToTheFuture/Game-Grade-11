/**
 * 
 */
package com.bayviewglen.vo;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;

public abstract class Item implements Serializable{


	/** The item name. */
	private BufferedImage itemImage;
	private String itemName; 

	/** The weight. */
	int weight = 0;
	
/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param wieght the new weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean noItem(){
		return getWeight() <= 0; 
	}	
	
	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public BufferedImage getItemImage() {
		return itemImage;
	}

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
	
		public String getItemName(){
		return itemName; 
	}
	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
