package com.RM.model;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import com.RM.tools.Globle;

public class coin{
	private int x=0,y=0;     //金币坐标

	private boolean isdead=false;
	public boolean getIsdead() {
		return isdead;
	}
	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}
	Image coin;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public coin(int x,int y){
		try {
			coin=ImageIO.read(new File("images//coins//coin.png")).getSubimage(0, 0, 40,40);
			this.x=x;
			this.y=y;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //金币图标
	}
	public void coinmove(){   //金币移动
		x-=Globle.Speed;
		if(x+49<0){
            isdead=true;  
		}
     }
	public void draw(Graphics g){
		g.drawImage(coin, x, y,null);
	}
}
