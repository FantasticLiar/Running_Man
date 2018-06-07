package com.RM.view;
import javax.swing.*;

import com.RM.ImageIO.*;
import com.RM.SoundIO.SoundRead;
import com.RM.tools.Fonts;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
/*
 * 开始界面
 */
public class StartJPanel extends JPanel implements ActionListener{
	MyJButton B_Start,B_Introduce,B_Record,B_Develop;
	JLabel characters,background,Back_characters,coin;
	int change=0;//改变人物
	JButton jb;
	BufferedImage im;
	GameJPanel gp;
	Loading l;
	SoundRead music_bgm_3,music_button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void initButton(){
		this.setLayout(null);
		B_Start=new MyJButton("开始游戏",290,30);
		B_Start.setBounds(290,30,160,45);
		B_Start.addActionListener(this);
		
		B_Introduce=new MyJButton(" 简    介",290,90);
		B_Introduce.setBounds(290,90,160,45);
		B_Introduce.addActionListener(this);
		
		B_Record=new MyJButton("排  行  榜",290,150);
		B_Record.setBounds(290,150,160,45);
		B_Record.addActionListener(this);
		
		B_Develop=new MyJButton(" 开    发",290,210);
		B_Develop.setBounds(290,210,160,45);
		B_Develop.addActionListener(this);
		
		Image im=new ReadImage("images//change_button.png").getSourImage();
		jb=new JButton();
		jb.setIcon(new ImageIcon(im));
		jb.setSize(im.getWidth(this),im.getHeight(this));
		jb.setBounds(180,240,35,35);
		jb.addActionListener(this);
		
		this.add(B_Start);
		this.add(B_Introduce);
		this.add(B_Record);
		this.add(B_Develop);
		this.add(jb);
	}
	public void initCharacters(String name,Graphics g){
		im=new ReadImage(name).getSourImage();
		g.drawImage(im,20,50,this);
	}
	public void initBackground(){
		background=new JLabel(new ImageIcon(new ReadImage(ImageName.Background).getSourImage()));
		background.setBounds(0,0,480,360);
		Back_characters=new JLabel(new ImageIcon(new ReadImage(ImageName.Back_characters).getImage(0,30,257,330)));
		Back_characters.setBounds(0,-30,257,360);
		coin=new JLabel(new ImageIcon(new ReadImage(ImageName.Coin_back).getSourImage()));
		coin.setBounds(-20,0,210,333);
		this.add(coin);
		this.add(Back_characters);
		this.add(background);
		
	}
	public StartJPanel(Loading l){
		this.gp=gp;
		this.l=l;
		music_bgm_3=new SoundRead("bgm_3.wav");
		music_bgm_3.audioclip.loop();
		music_button=new SoundRead("button.wav");
		initButton();
		//初始化人物放在了paint函数里面
		//initCharacters(name, g);
		initBackground();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==B_Start){
			music_bgm_3.audioclip.stop();
			music_button.audioclip.play();
			Thread d=new Thread(l);
			d.start();
			MainJpanel.cl.show(this.getParent(),"5");	
		}else if(arg0.getSource()==B_Introduce){
			music_button.audioclip.play();
			MainJpanel.cl.show(this.getParent(),"2");
		}else if(arg0.getSource()==B_Record){
			music_button.audioclip.play();

		}else if(arg0.getSource()==B_Develop){
			music_button.audioclip.play();
			MainJpanel.cl.show(this.getParent(),"4");
		}else if(arg0.getSource()==jb){
			music_button.audioclip.play();
			change++;
			this.repaint();
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		if(change%2==0){
			initCharacters(ImageName.Characters3,g);
		}else {
			initCharacters(ImageName.Characters4,g);
		}
	}
}
