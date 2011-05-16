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
	public Building(Room townEntrance, Room tunnelEntrance, Tunnel t, Room outside) {
		rooms.set(0, townEntrance);
		rooms.set(1, tunnelEntrance);
		// TODO Auto-generated constructor stub
	}

	ArrayList<Room> rooms = new ArrayList<Room>(2);
	//Index 0 Will always be the town entrance for the building.
	//Index 1 Will always be the tunnel entrance.

	// When you enter a house, you will automatically enter into the front entrance room.
	Room frontEntrance;
	
	// When you enter a building from a tunnel, you will enter into the tunnelEntrance Room.
	Room tunnelEntrance;
	
}
