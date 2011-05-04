/**
 * 
 */
package com.bayviewglen.windows;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import com.bayviewglen.vo.Game;
import com.bayviewglen.vo.Town;

/**
 * @author kdeslauriers
 * @author bivanovic
 * 
 */
public class GameGUI implements ActionListener, KeyListener, MouseListener, Serializable{

	private Game game;
	private JMenuBar menuBar;
	private JMenu gameMenu, commandMenu, helpMenu;
	private JMenuItem[] gameMenuItems = new JMenuItem[4];
	private JMenuItem[] cmdMenuItems = new JMenuItem[4];
	private JMenuItem[] helpMenuItems = new JMenuItem[2];

	private final static int MENU_NEW = 0;
	private final static int MENU_LOAD = 1;
	private final static int MENU_SAVE = 2;
	private final static int MENU_EXIT = 3;

	private final static int MENU_INVSTAT = 0;
	private final static int MENU_MAP = 1;
	private final static int MENU_TRADE = 2;
	private final static int MENU_DOORCHEST = 3;

	private final static int MENU_HELP = 0;
	private final static int MENU_ABOUT = 1;

	private GameGUI(){
		JFrame frame = new JFrame("Game Title");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		frame.setSize(dim.width, dim.height);

		initGameMenu(frame, this);

		frame.addKeyListener(this);
		frame.addMouseListener(this);
		frame.setVisible(true);
	}

	public void initGameMenu(JFrame frame, GameGUI mainGame){
		menuBar = new JMenuBar();

		/* Basic Game */
		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);

		gameMenuItems[MENU_NEW] = new JMenuItem("New Game");
		gameMenuItems[MENU_NEW].addActionListener(mainGame);
		gameMenu.add(gameMenuItems[MENU_NEW]);
		gameMenu.addSeparator();

		gameMenuItems[MENU_LOAD] = new JMenuItem("Load");
		gameMenuItems[MENU_LOAD].addActionListener(mainGame);
		gameMenu.add(gameMenuItems[MENU_LOAD]);

		gameMenuItems[MENU_SAVE] = new JMenuItem("Save");
		gameMenuItems[MENU_SAVE].addActionListener(mainGame);
		gameMenuItems[MENU_SAVE].setEnabled(false);
		gameMenu.add(gameMenuItems[MENU_SAVE]);
		gameMenu.addSeparator();

		gameMenuItems[MENU_EXIT] = new JMenuItem("Exit");
		gameMenuItems[MENU_EXIT].addActionListener(mainGame);
		gameMenu.add(gameMenuItems[MENU_EXIT]);


		/* Game Play */
		commandMenu = new JMenu("Commands");
		commandMenu.setEnabled(false);
		menuBar.add(commandMenu);

		cmdMenuItems[MENU_INVSTAT] = new JMenuItem("Inventory/Statistics");
		cmdMenuItems[MENU_INVSTAT].addActionListener(mainGame);
		commandMenu.add(cmdMenuItems[MENU_INVSTAT]);

		cmdMenuItems[MENU_MAP] = new JMenuItem("View Map");
		cmdMenuItems[MENU_MAP].addActionListener(mainGame);
		commandMenu.add(cmdMenuItems[MENU_MAP]);

		cmdMenuItems[MENU_TRADE] = new JMenuItem("Trade");
		cmdMenuItems[MENU_TRADE].addActionListener(mainGame);
		commandMenu.add(cmdMenuItems[MENU_TRADE]);

		cmdMenuItems[MENU_DOORCHEST] = new JMenuItem("Open Door/Chest");
		cmdMenuItems[MENU_DOORCHEST].addActionListener(mainGame);
		commandMenu.add(cmdMenuItems[MENU_DOORCHEST]);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		/*Help Menu */
		helpMenuItems[MENU_HELP] = new JMenuItem("Game Help");
		helpMenuItems[MENU_HELP].addActionListener(mainGame);
		helpMenu.add(helpMenuItems[MENU_HELP]);
		helpMenuItems[MENU_ABOUT] = new JMenuItem("About the Game");
		helpMenuItems[MENU_ABOUT].addActionListener(mainGame);
		helpMenu.add(helpMenuItems[MENU_ABOUT]);

		frame.setJMenuBar(menuBar);
	}

	public static void save(Game game){
		String filename = "test.sav";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(game);
			out.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("Successfully Saved!");
	}

	public static Game load(){
		String filename = "test.sav";

		Game game = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		if(!(new File(filename)).exists()){
			System.err.println("There is no file with the name " + filename + "!");
			return null;
		}
		try
		{
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			game = (Game)in.readObject();
			in.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}

		System.out.println("Loaded Successfully!");
		return game;
	}

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

	public void actionPerformed(ActionEvent e) {
		System.out.println("Mouse was pressed on " + e.getActionCommand());

		if("Save".equalsIgnoreCase(e.getActionCommand())){
			if(game == null)
				return;
			save(game);
		}

		else if("Load".equalsIgnoreCase(e.getActionCommand())){
			if(game != null)
				System.out.println("Are you sure you want to stop this game? Any unsaved data will be lost!");
			game = load();

			commandMenu.setEnabled(true);
			gameMenuItems[MENU_SAVE].setEnabled(true);

			System.out.println(game.getPlayerName() + " " + game.getPoints());
		}

		/**
		 * If game is not <code>null</code>, ask the user if they are sure as any unsaved
		 * data will be lost.
		 */
		else if("New Game".equalsIgnoreCase(e.getActionCommand())){
			game = new Game();

			commandMenu.setEnabled(true);
			gameMenuItems[MENU_SAVE].setEnabled(true);

			game.testInit("Boris", 125);
		}

		else if("Exit".equalsIgnoreCase(e.getActionCommand())){
			/*final JOptionPane optionPane = new JOptionPane("Are you sure you want to exit?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
			final JDialog dialog = new JDialog();
			optionPane.addPropertyChangeListener(
					new PropertyChangeListener(){
						public void propertyChange(PropertyChangeEvent e) {
							String prop = e.getPropertyName();

							if (dialog.isVisible() && (e.getSource() == optionPane) && (prop.equalsIgnoreCase("value"))){
								System.exit(0);
							}

							else if ((dialog.isVisible() && (e.getSource() == optionPane) && (prop.equals(JOptionPane.VALUE_PROPERTY)))){
								System.out.println(prop);
								dialog.setVisible(false);
							}
						}
					});
			dialog.add(optionPane);
			dialog.pack();
			dialog.setVisible(true);*/
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		GameGUI frame = new GameGUI();
	}
}
