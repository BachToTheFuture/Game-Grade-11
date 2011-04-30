/**
 * 
 */
package com.bayviewglen.gameutils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author kdeslauriers
 *
 */
public class GraphicUtils {

	public static BufferedImage[] readSpriteSheet(String fileName, int rows, int cols, int width, int height) throws IOException{
		BufferedImage bigImg = ImageIO.read(new File(fileName)); 
		BufferedImage[] sprites = new BufferedImage[rows * cols];
		
		for (int i=0; i<rows; i++){
			for (int j=0; j<cols; j++){
				sprites[(i * cols) + j] = bigImg.getSubimage(i*width, j*height, width, height);
			}
		}
		
		return sprites;
	}
	
}
