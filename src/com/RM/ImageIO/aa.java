package com.RM.ImageIO;

import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class aa extends JFrame{
	JLabel jl;
	ImageIcon im;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new aa();
	}
	public aa(){
		im=new ImageIcon(new ReadImage("images//Background//Game_Background.jpg").getSourImage());
		jl=new JLabel(im);
		jl.setBounds(50,50,1024,433);
		JPanel jp=new TestJFrame();
		jp.setBounds(50, 80,300, 300);
		this.add(jp);this.add(jl);
		this.setBackground(Color.BLACK);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
