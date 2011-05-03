/**
 * 
 */
package com.bayviewglen.windows;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private ListenerForKeys lfk = new ListenerForKeys();
	private ListenerForMouse lfm = new ListenerForMouse();
	
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
		
		frame.addKeyListener(lfk);
		frame.addMouseListener(lfm);
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
	
	private class ListenerForKeys implements KeyListener
	{
		public void keyPressed(KeyEvent e)
		{
			System.out.println("Key Pressed: " + e.getKeyCode());
			System.out.println(e.getModifiersEx());
			System.out.println(e.isShiftDown());
		}

		public void keyReleased(KeyEvent e)
		{

		}

		public void keyTyped (KeyEvent e)
		{

		}

	}
	
	private class ListenerForMouse implements MouseListener
	{

		public void mouseClicked(MouseEvent e) {
			System.out.println("Mouse was pressed on " + e.getComponent().getName());
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

	}
	
}
