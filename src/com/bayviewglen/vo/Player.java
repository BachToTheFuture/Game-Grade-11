/**
 * 
 */
package com.bayviewglen.vo;

import java.io.Serializable;

import com.bayviewglen.game.CharacterSprite;
import com.bayviewglen.gameutils.ImagesLoader;

/**
 * @author kdeslauriers
 *
 */
public class Player extends HumanControlledCharacter implements Serializable{
	
	private String name;
	private int hp = 100;
	private int exp;
	
	
	public int getExp() {
		return exp;
	}

	public void addExp(int addedExp) {
		exp += addedExp;
	}

	public Player(String playerName, int PWIDTH, int PHEIGHT, ImagesLoader imsLoader, long period){
		name = playerName;
		setSprite(new CharacterSprite(PWIDTH, PHEIGHT, imsLoader, (int)(period/1000000L) )); // in ms
	}
	

	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return hp;
	}
	
	public void setHealth(int newHealth){
		hp = newHealth;
	}
	


	


}
