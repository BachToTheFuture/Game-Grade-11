/**
 * 
 */
package com.bayviewglen.vo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * @author kdeslauriers
 *
 */
public class Player extends HumanControlledCharacter implements Serializable{
	
	private String name;
	private int x, dx, y;
	private int hp = 100;
	private int exp;
	private Image still;
	
	public int getExp() {
		return exp;
	}

	public void addExp(int addedExp) {
		exp += addedExp;
	}

	public Player(String playerName){
		name = playerName;
		ImageIcon i = new ImageIcon("images/sampleplayer.png");
		still = i.getImage();
		x = 10;
		y = 10;
	}
	
	public void move(){
		x += dx;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getImage(){
		return still;
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
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
			dx = -1;
		else if (key == KeyEvent.VK_RIGHT)
			dx = 1;
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
			dx = 0;
		else if (key == KeyEvent.VK_RIGHT)
			dx = 0;
	}
}
