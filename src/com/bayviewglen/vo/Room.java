/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author kdeslauriers
 *
 */
public class Room extends Space implements Serializable {
	
	ArrayList<Item> items;
	ArrayList<Character> characters;
	
	public Room(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addItem(Item item){
		items.add(item);
	}
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public ArrayList<Item> getItems(){
		return items;
	}

	
	/**
	 * Removes the item.
	 *
	 * @param item the item
	 * @return the item
	 */
	public Item removeItem(Item item){
		items.remove(item);
		return item;
	}
	
	/**
	 * Checks for items.
	 *
	 * @return true, if successful
	 */
	public boolean hasItems(){
		return items.size()>0;
	}
		
}
