/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;

import com.bayviewglen.game.CharacterSprite;


public abstract class Character implements Serializable{
	
	private CharacterSprite sprite;
	
	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(CharacterSprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the sprite
	 */
	public CharacterSprite getSprite() {
		return sprite;
	}
	
	public boolean isMoving() {
		return sprite.isMoving();
	}

	public void setMoving(boolean b) {
		sprite.setMoving(b);
		
	}

	public void attack(Integer orientation){
		sprite.attack(orientation);
	}
	
	public void moveLeft() {
		sprite.moveLeft();
		
	}

	public void stayStill() {
		sprite.stayStill();
		
	}

	public void moveRight() {
		sprite.moveRight();
		
	}
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

