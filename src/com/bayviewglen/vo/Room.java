/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author kdeslauriers
 *
 */
public class Room extends Space implements Serializable {
	
	public Room(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	ArrayList<Item> items;
	ArrayList<Character> characters;
	HashMap<String, Room> exits;
	
}
