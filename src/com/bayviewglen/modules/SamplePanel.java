package com.bayviewglen.modules;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.bayviewglen.vo.Player;

/**
 * @author bivanovic
 *
 */
public class SamplePanel extends JPanel implements ActionListener{

	Player p;
	Image img;
	Timer time;

	public SamplePanel(){
		p = new Player("Enter Player Name");
	//	addKeyListener(new AL());
		setFocusable(true);
		setVisible(true);
		ImageIcon i = new ImageIcon("images/samplebackground.PNG");
		img = i.getImage();
		time = new Timer(10, this);
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}

