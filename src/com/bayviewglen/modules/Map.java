package com.bayviewglen.modules;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener, Serializable{

	private ArrayList<String> cityName = new ArrayList<String>();
	private File cityNames = new File("City Names.txt");
	private Image img;
	private Timer time;
	private JFrame guiFrame;

	public Map(JFrame frame){
		guiFrame = frame;
		
		setFocusable(true);
		addKeyListener(new AL());
		ImageIcon i = new ImageIcon("Tech Game Map.JPG");
		img = i.getImage();
		setVisible(true);
		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);
	}

	public void close(){
		setVisible(false);
		guiFrame.getContentPane().remove(this);
		guiFrame.requestFocusInWindow();
	}
	
	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){

		}

		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			System.out.println("Map Captured Key Strokes");
			if (key == KeyEvent.VK_M){
				close();
			}
		}
	}
}
