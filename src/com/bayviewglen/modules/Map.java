package com.bayviewglen.modules;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{
	
	ArrayList<String> cityName = new ArrayList<String>();
	File cityNames = new File("City Names.txt");
	Image img;
	Timer time;
	
	public Map(){
		setFocusable(true);
		addKeyListener(new AL());
		setFocusable(true);
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
	
	public void stop(){
		time.stop();
	}
	
	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){}
		
		public void keyPressed(KeyEvent e){}
	}
}
