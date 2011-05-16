/**
 * 
 */
package com.bayviewglen.windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bayviewglen.modules.Map;
import com.bayviewglen.modules.SamplePanel;
import com.bayviewglen.vo.Game;

/**
 * @author kdeslauriers
 * @author bivanovic
 * 
 */
public class GameGUI implements ActionListener, KeyListener, MouseListener, Serializable{

	private Game game;
	private static JMenuBar menuBar;
	private static JMenu gameMenu, commandMenu, helpMenu;
	private static JMenuItem[] gameMenuItems = new JMenuItem[4];
	private static JMenuItem[] cmdMenuItems = new JMenuItem[4];
	private static JMenuItem[] helpMenuItems = new JMenuItem[2];

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
	private static JFrame frame;

	private GameGUI(){
		frame = new JFrame("Game Title");

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
		JFileChooser fileopen = new JFileChooser("Save Files");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Save Files (*.sav)", "sav");
		fileopen.addChoosableFileFilter(filter);

		int ret = fileopen.showDialog(null, "Save");

		File file = new File("");
		if (ret == JFileChooser.APPROVE_OPTION) {
			file = new File(fileopen.getSelectedFile().getAbsolutePath());

			if(file.getName().indexOf('.') > 0){
				file = new File(fileopen.getSelectedFile().getAbsolutePath().substring(0, file.getAbsolutePath().indexOf('.')));

			}
		}

		if (ret == JFileChooser.CANCEL_OPTION) {
			return;
		}

		file = new File(file.getAbsolutePath() + ".sav");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);
			out.writeObject(game);
			out.close();
			Object[] objects = {"Ok"};
			JOptionPane.showOptionDialog(frame,	"Successfully Saved!", "Success!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon("Icons/ok.png"), objects, objects[0]);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not found!");
		} 
		catch (IOException e) {
			System.out.println("There was an error saving to the file!");
		}
	}

	public static Game load(){
		JFileChooser fileopen = new JFileChooser("Save Files");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Save Files (*.sav)", "sav");
		fileopen.addChoosableFileFilter(filter);

		int ret = fileopen.showDialog(null, "Load");

		String filename = "";
		if (ret == JFileChooser.APPROVE_OPTION) {
			filename = fileopen.getSelectedFile().getAbsolutePath();
		}

		if (!(filename.endsWith(".sav"))){
			Object[] options = {"Ok"};
			JOptionPane.showOptionDialog(frame,	"Invalid file extension!", "Warning", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
			return null;
		}

		Game game = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;

		try
		{
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			game = (Game)in.readObject();
			in.close();
			System.out.println("Loaded Successfully!");
			commandMenu.setEnabled(true);
			gameMenuItems[MENU_SAVE].setEnabled(true);
			Object[] objects = {"Ok"};
			JOptionPane.showOptionDialog(frame,	"Successfully Loaded!", "Success!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon("Icons/ok.png"), objects, objects[0]);

		}
		catch(IOException ex){
			Object[] objects = {"Ok"};
			JOptionPane.showOptionDialog(frame,	"Invalid File Contents", "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, objects, objects[0]);
		}
		catch(ClassNotFoundException ex){}
		return game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_0){
			SamplePanel sp = new SamplePanel();
			frame.getContentPane().add(sp);
			
			// If you do not include this then you will not be able perform input in the panel.
			sp.requestFocusInWindow();
			// You need this to be able to update the frame with the panel
			frame.setVisible(true);
		}
		
		else if (key == KeyEvent.VK_M){
			Map map = new Map();
			frame.getContentPane().add(map);
			
			map.requestFocusInWindow();
			frame.setVisible(true);
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped (KeyEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
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
		if("Save".equalsIgnoreCase(e.getActionCommand())){
			if(game == null)
				return;
			save(game);
		}

		else if("Load".equalsIgnoreCase(e.getActionCommand())){
			if(game != null){
				//If game is not null, ask the user if they are sure as any unsaved
				//data will be lost.
			}

			game = load();
		}

		else if("New Game".equalsIgnoreCase(e.getActionCommand())){
			game = new Game();

			commandMenu.setEnabled(true);
			gameMenuItems[MENU_SAVE].setEnabled(true);
		}

		else if("Exit".equalsIgnoreCase(e.getActionCommand())){
			Object[] options = {"Save and Exit", "Exit", "Cancel"};
			int n = JOptionPane.showOptionDialog(frame,	"Are you sure you want to exit?\nAny unsaved data will be lost!", "", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);

			if(n == 0){
				save(game);
				System.exit(0);
			}

			else if(n == 1)
				System.exit(0);
		}
	}

	public static void main(String[] args) {
		GameGUI frame = new GameGUI();
	}
}
