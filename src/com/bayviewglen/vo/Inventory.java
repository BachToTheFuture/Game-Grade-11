package com.bayviewglen.vo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Inventory extends JPanel  {
	
	private BufferedImage image;

    public Inventory() {
       try {                
          image = ImageIO.read(new File("images/bosses.png"));
       } catch (IOException ex) {
            System.out.print("oops");
       }
       repaint(); 
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the paramet
		
	}
    
   public JPanel JP(){
	   return this; 
	   
   } 
}
	

