/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;

/**
 * @author kdeslauriers
 *
 */
public abstract class HumanControlledCharacter extends Character implements Serializable{

	/**
	 * Kills the player. If they were in a building, it re-spawns them to the entrance
	 * from which they entered (either the TunnelEntrance or RoomEntrance). 
	 * 
	 * @param canRespawn: chooses whether or not the player re-spawns.
	 */

	public void die(boolean canRespawn){
		
	}
	
}
