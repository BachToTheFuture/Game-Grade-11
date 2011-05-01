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
public class Room implements Serializable{
	ArrayList<Item> items;
	ArrayList<Character> characters;
	
	HashMap<String, Room> exits;
}
