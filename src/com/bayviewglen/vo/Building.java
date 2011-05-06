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
public class Building extends Space implements Serializable{
	public Building(int x, int y) {
		super(0, 0);
		// TODO Auto-generated constructor stub
	}

	ArrayList<Room> rooms;

	// When you enter a house, you will automatically enter into the front entrance room.
	Room frontEntrance;
	
	// When you enter a building from a tunnel, you will enter into the tunnelEntrance Room.
	Room tunnelEntrance;
	
}
