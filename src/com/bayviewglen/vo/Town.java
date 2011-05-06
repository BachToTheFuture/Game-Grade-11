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
public class Town extends Space implements Serializable{
	public Town(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	ArrayList<Building> buildings;
	ArrayList<Character> characters;
	ArrayList<Item> items;
}
