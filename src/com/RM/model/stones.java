package com.RM.model;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import com.RM.tools.Globle;

public class stones {
	private int x = 0, y = 0; // 石头坐标
	private boolean isdead = false;

	public boolean getIsdead() {
		return isdead;
	}

	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}

	Image stones;

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

	public stones(int x, int y) {
		try {
			int i = (int) Math.random() * 2;
			if (i == 1) {
				stones = ImageIO.read(new File("images//coins//stones_1.png")).getSubimage(0, 0, 40, 39);
			} else {
				stones = ImageIO.read(new File("images//coins//stones_2.png")).getSubimage(0, 0, 40, 40);
			}
			this.x = x;
			this.y = y;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 金币图标
	}

	public void stonesmove() { // 金币移动
		x-=Globle.Speed;
		if (x+49 < 0) {
			isdead = true;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(stones, x, y, null);
	}
}
