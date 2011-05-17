package com.bayviewglen.modules;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.bayviewglen.vo.Player;

/**
 * @author bivanovic
 *
 */
public class SamplePanel extends JPanel implements ActionListener{

	private Player p;
	private Image img;
	private Timer time;
	private JFrame guiFrame;

	public SamplePanel(JFrame frame){
		guiFrame = frame;

		p = new Player("Enter Player Name");
		addKeyListener(new AL());
		setFocusable(true);
		setVisible(true);
		ImageIcon i = new ImageIcon("images/samplebackground.PNG");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
	}

	public void close(){
		setVisible(false);
		
		guiFrame.getContentPane().remove(this);
		guiFrame.requestFocusInWindow();
	}

	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			p.keyReleased(e);
		}

		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();

			if(key == KeyEvent.VK_0){
				close();
			}
			p.keyPressed(e);
		}
	}
}

