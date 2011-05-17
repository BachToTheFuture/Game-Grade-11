/**
 * 
 */
package com.bayviewglen.vo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ImageIcon;

import com.bayviewglen.gameutils.GraphicUtils;

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

	public Player(String playerName){
		name = playerName;
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
