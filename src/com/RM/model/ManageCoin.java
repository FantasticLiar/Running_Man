package com.RM.model;

import java.awt.*;
import java.awt.List;
import java.util.*;

import com.RM.tools.Globle;

public class ManageCoin {
	public static ArrayList<coin> myCoinList=new ArrayList<coin>();
	coin cc;
	public ManageCoin(){
	}
	//��ӽ��
	public void addCoin(coin c){
		this.myCoinList.add(c);
//		System.out.println("��Ҹ�����"+myCoinList.size());
	}
	//�ж������ڵĽ���Ƿ�����
	public void Move_Draw_Judge(Graphics g){
		for(int i=0;i<myCoinList.size();i++){	
			cc=myCoinList.get(i);
			cc.coinmove();
			cc.draw(g);
			if(cc.getIsdead()==true){
				delCoin(cc);
			}
		}
	}
	//ɾ�����
	public void delCoin(coin c){
	    myCoinList.remove(c);
	}
	//����������
	public void createCoin(){	
			int x=Globle.Window_width;
			int y=(int)(Math.random()*2+1)*40;
			coin c=new coin(x,Globle.Window_height-y-120);
			addCoin(c);
	}
}
