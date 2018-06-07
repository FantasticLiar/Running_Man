package com.RM.view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.RM.SoundIO.SoundRead;
import com.RM.tools.Fonts;

public class MyJButton extends JButton implements MouseListener{
	String text;
	int x,y;//button的坐标
	int state;//1表示鼠标没进入，2表示鼠标进入了
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public MyJButton(String text,int x,int y){
		super();
		this.text=text;
		this.addMouseListener(this);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));//设置手型图标
		this.setBorderPainted(false);//设置边框不可绘制
		this.setFocusPainted(false);//焦点绘制
		this.setContentAreaFilled(false);//是否填充，false可以让按钮看起来透明
		}
	public void paint(Graphics g){
		super.paint(g);
		try {
			if(state==1){
				g.drawImage(ImageIO.read(new File("images//button_bg.png")),x, y,160,45,this);
			}else{
				g.drawImage(ImageIO.read(new File("images//button_click.png")),x, y,160,45,this);
			}
			g.setFont(Fonts.myfont_button_bold);
			g.setColor(Color.cyan);
			g.drawString(text,x+18,y+29);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		state=2;
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		state=1;
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
