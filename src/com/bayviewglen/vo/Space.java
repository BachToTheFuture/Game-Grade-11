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
	 * @param i - the Item to be added.
	 * @param x - the x-position that the Item will be placed within the room.
	 * @param y - the y-position that the Item will be placed within the room.
	 * @return true if the Item is successfully added, false otherwise.
	 */
	public boolean addItem(Item i, int x, int y){
		
		return false;
	}
	
}
