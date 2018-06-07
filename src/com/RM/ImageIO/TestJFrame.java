package com.RM.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TestJFrame extends JPanel{
	Image sourImage;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public TestJFrame(){
		try {
			sourImage=new ImageIcon(ImageIO.read(new File("images//characters//Actions3.png"))).getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(sourImage, 0,0,null);
	}

}
