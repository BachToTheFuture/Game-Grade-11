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
public class Building implements Serializable{
	ArrayList<Room> rooms;

	// When you enter a house, you will automatically enter into the front entrance room.
	Room frontEntrance;
	
	// When you enter a building from a tunnel, you will enter into the tunnelEntrance Room.
	Room tunnelEntrance;
	
}
