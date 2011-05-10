package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;

abstract class Space implements Serializable{

	//A SPACE is anywhere that a player can walk, an item can be placed,
	//or a character can exist.

	private ArrayList<Character> characters;
	private ArrayList<Item> items;

	private int xSize, ySize;
	//The size of the space.

	/**
	 * Default constructor.
	 * @param x - the width of the space to be created.
	 * @param y - the height of the space to be created.
	 */
	public Space (int x, int y){
		this.xSize = x;
		this.ySize = y;
	}

	/**
	 * @param i - the item to be added
	 * @return true if the Item is successfully added, false if the bounds specified in the
	 * item's constructor are outside the bounds of the space.
	 */
	public boolean addItem(Item i, int x, int y){

		if (i.getxPosition() > 0 && i.getxPosition() < xSize && 
				i.getyPosition() > 0 && i.getyPosition() < ySize && 
				isEmpty(x, y)){
			items.add(i);
			return false;
		}
		return false;
	}

	/**
	 * Checks if a point in space is empty.
	 * @param x - the x-coordinate of the point to be checked.
	 * @param y - the y-coordinate of the point to be checked.
	 * @return true if there is nothing at that point in space, false otherwise.
	 */
	public boolean isEmpty(int x, int y){
		for (Item i : items){
			if (i.getxPosition() <= x && x <= (i.getxPosition() + i.getxSize())){
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if a box in the space is empty.
	 * @param x - the x-coordinate of the TOP LEFT point on the box.
	 * @param y - the y-coordinate of the TOP LEFT point on the box.
	 * @param width - the width of the box. (A positive integer)
	 * @param height - the height of the box. (A positive integer)
	 * @return true if no items or characters are inside the box, false otherwise.
	 * @throws NullPointerException if any point in the box is outside the space's
	 * bounds.
	 */
	public boolean isBoxEmpty(int x, int y, int width, int height){
		if (x < 0 || x > xSize || y < 0 || y > ySize){
			throw new NullPointerException();
			
		} else if (ySize < 0 || xSize < 0){
			throw new NullPointerException();
			
		} else if (x + width > xSize || y + height > ySize){
			throw new NullPointerException();
			
		} else {
			for (int i = x; i < (x+width); i++){
				for (int j = y; j < (y+height); i++){
					if (!isEmpty(i, j))
						return true;
				}
			}
		}
		return false;
	}

}
