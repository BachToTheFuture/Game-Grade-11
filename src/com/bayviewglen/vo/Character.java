/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class Character implements Serializable{
	/** The items. */
	private ArrayList<Item> items;
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
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
	 * Checks for items.
	 *
	 * @return true, if successful
	 */
	public boolean hasItems(){
		return items.size()>0;
	}
	/**
	 * Return items.
	 */
	public void returnItems(){
		for (int i = 0 ; i< items.size() ; i++){
			System.out.println((i+1)+". "+ items.get(i).getItemImage());
		}
	}
	
	/**
	 * Removes the item.
	 *
	 * @param item the item
	 */
	public void removeItem(Item item){
		items.remove(item);
	}

	/**
	 * Items weights.
	 *
	 * @return the int
	 */
	public int itemsWeights() {
		int w =0;
		for (int i = 0 ; i< items.size() ; i++){
			w += items.get(i).getWeight();
		}
		return w;
	}
	
	
}
