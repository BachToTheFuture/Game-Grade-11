/**
 * 
 */
package com.bayviewglen.vo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author kdeslauriers
 *
 */
public class Room {
	ArrayList<Item> items;
	ArrayList<Character> characters;
	
	HashMap<String, Room> exits;
}
