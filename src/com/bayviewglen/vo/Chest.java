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
public class Chest extends Item implements Serializable{
	ArrayList<Item> items;
	
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
