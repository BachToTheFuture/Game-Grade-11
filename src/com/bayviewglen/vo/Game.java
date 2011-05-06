/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;
import java.util.ArrayList;

import com.bayviewglen.vo.*;

/**
 * @author bivanovic
 *
 */
public class Game implements Serializable{

	private ArrayList<Town> villages;
	private String playerName;
	private int points;
	
	public void testInit(String name, int points){
		playerName = name;
		this.points = points;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPoints() {
		return points;
	}
	
	
}
