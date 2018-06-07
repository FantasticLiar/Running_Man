package com.RM.model;

import java.awt.*;
import java.awt.List;
import java.util.*;

import com.RM.tools.Globle;

public class ManageStones {
	public static ArrayList<stones> myStonesList = new ArrayList<stones>();
	stones ss;

	public ManageStones() {
		
	}

	// 添加金币
	public void addStones(stones s) {
		this.myStonesList.add(s);
//		System.out.println("石头个数:"+myStonesList.size());
	}

	// 判断数组内的金币是否死亡
	public void Move_Draw_Judge(Graphics g) {
		for (int i = 0; i < myStonesList.size(); i++) {
			ss = myStonesList.get(i);
			ss.stonesmove();
			ss.draw(g);
			if (ss.getIsdead() == true) {
				delStones(ss);
			}		
		}
	}

	// 删除金币
	public void delStones(stones s) {
		myStonesList.remove(s);
	}

	// 随机产生金币
	public void createStones() {
		if ((int) (Math.random() * 2) == 1) {
			int x = Globle.Window_width;
			int y = 40;
			stones s = new stones(x, Globle.Window_height - y - 120);
			addStones(s);
		}
	}
}
