/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author kdeslauriers
 *
 */
public class Tunnel implements Serializable{
	ArrayList<Building> buildings;
	ArrayList<Character> characters;
	ArrayList<Item> items;
	
	// This will have two exits that are building.  Each Building has a room that contains a tunnel
	// entrance.  This is the room that the player will be entering from a tunnel.
	
	
	// Tunnels may be joined together via other tunnels.  I have a few ideas about
	// this but for now I am leaving this undecided.
	
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
