/**
 * 
 */
package com.bayviewglen.windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.bayviewglen.vo.Town;

/**
 * @author kdeslauriers
 *
 */
public class Game {

	private ArrayList<Town> villages;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game frame = new Game();

	}

	private Game(){
		JFrame frame = new JFrame("Game Title");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		frame.setSize(dim.width, dim.height);
		
		initGameMenu(frame);
		
		frame.setVisible(true);

	}
	
	public static void initGameMenu(JFrame frame){
		JMenuBar menuBar;
		JMenu game, gameplay, help;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();
		
		/* Basic Game */
		game = new JMenu("Game");
		menuBar.add(game);
		
		menuItem = new JMenuItem("New Game");
		game.add(menuItem);
		game.addSeparator();
		menuItem = new JMenuItem("Load");
		game.add(menuItem);
		menuItem = new JMenuItem("Save");
		game.add(menuItem);
		game.addSeparator();
		menuItem = new JMenuItem("Exit");
		game.add(menuItem);
		
		
		/* Game Play */
		gameplay = new JMenu("Commands");
		menuBar.add(gameplay);
		
		menuItem = new JMenuItem("Inventory/Statistics");
		gameplay.add(menuItem);
		menuItem = new JMenuItem("View Map");
		gameplay.add(menuItem);
		menuItem = new JMenuItem("Trade");
		gameplay.add(menuItem);
		menuItem = new JMenuItem("Open Door/Chest");
		gameplay.add(menuItem);
		
		help = new JMenu("Help");
		menuBar.add(help);
		
		/*Help Menu */
		menuItem = new JMenuItem("Game Help");
		help.add(menuItem);
		menuItem = new JMenuItem("About the Game");
		help.add(menuItem);
		
		frame.setJMenuBar(menuBar);
	}
	
}
