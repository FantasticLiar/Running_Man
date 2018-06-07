package com.RM.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.RM.ImageIO.ImageName;
import com.RM.ImageIO.ReadImage;
import com.RM.SoundIO.SoundRead;
import com.RM.model.ManageCoin;
import com.RM.model.ManageStones;
import com.RM.tools.Fonts;
import com.RM.tools.Globle;

public class Loading extends JPanel implements Runnable{
	Image Loading,Loading1;
	int x=0;
	int y=0;
	int time=0;//第几次启动加载界面，第一次就不用初始化GameJPanel的数据
	GameJPanel gp;
	int process[]={15,31,49,67,90,100,139,149,160,169,210,250,280};
	String Tips[]={"游","戏","虽","然","好","玩",",","可","不","要","沉","迷","哦"};
	public static void main(String[] args) {
	}
	public Loading(){
		Loading=new ReadImage(ImageName.Loading).getImage(0,20,480,210);
	}
	public void getGameJPanel(GameJPanel gp){
		this.gp=gp;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0,Globle.Window_width,Globle.Window_height);
		g.drawImage(Loading, 0,0,null);
		g.setColor(Color.cyan);
		g.fillRect(90,260,process[x],25);
		g.setColor(Color.red);
		g.drawRect(90,260,280,25);
		g.drawString("正  在  加  载  中 ， 请  稍  候  > > >",145,this.getHeight()-32);
		g.setFont(Fonts.myfont_JLabel_bold);
		for(int i=0;i<=y;i++){
			g.drawString(Tips[i],10+35*i,240);
		}
	}
	@Override
	public void run() {
		while(x!=process.length){
			this.repaint();	
			try {
				Thread.sleep(300);
				x++;
				y++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		x=0;y=0;
		Thread t=new Thread(gp);
		t.start();
		MainJpanel.cl.show(this.getParent(),"10");
	}
}
