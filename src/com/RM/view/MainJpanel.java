package com.RM.view;

import javax.swing.*;

import com.RM.SoundIO.SoundRead;
import com.RM.tools.Fonts;
import com.RM.tools.Globle;

import java.awt.*;
import java.awt.event.*;
/*
 * 主界面
 */
public class MainJpanel extends JFrame implements ActionListener{
	JMenuBar jmb;
	JMenu Start,Introduce,Record,Develop;
	JMenuItem S_startGame,S_stop,S_continue,S_exit,I_introduceGame,
	          I_control,R_record,D_kit,D_developer,D_thinking,D_time;
	JPanel jp;
	SoundRead music_stop,music_continue;
	static CardLayout cl=null;
	StartJPanel sj;
	IntroduceJPanel ij;
	GameJPanel gp;
	DevelopJPanel dj;
	RecordJPanel rj;
	Loading l;
	public static void main(String[] args) {
		new MainJpanel();
	}
	//写工具栏
	public void initJMenuBar(){
		jmb=new JMenuBar();
		
		Start=new JMenu("开始");
		Start.setFont(Fonts.myfont_title_bold);
		S_startGame=new JMenuItem("开始游戏");
		S_startGame.setFont(Fonts.myfont_title_bold);
		S_stop=new JMenuItem("暂停");
		S_stop.addActionListener(this);
		S_stop.setFont(Fonts.myfont_title_bold);
		S_continue=new JMenuItem("继续");
		S_continue.addActionListener(this);
		S_continue.setFont(Fonts.myfont_title_bold);
		S_exit=new JMenuItem("退出");
		S_exit.addActionListener(this);
		S_exit.setFont(Fonts.myfont_title_bold);
		Start.add(S_startGame);
		Start.add(S_stop);
		Start.add(S_continue);
		Start.add(S_exit);
		jmb.add(Start);

		Introduce=new JMenu("简介");
		Introduce.setFont(Fonts.myfont_title_bold);
		I_introduceGame=new JMenuItem("游戏介绍");
		I_introduceGame.setFont(Fonts.myfont_title_bold);
		I_control=new JMenuItem("控制方式");
		I_control.setFont(Fonts.myfont_title_bold);
		Introduce.add(I_introduceGame);
		Introduce.add(I_control);
		jmb.add(Introduce);

		Record=new JMenu("游戏记录");
		Record.setFont(Fonts.myfont_title_bold);
		R_record=new JMenuItem("英雄榜");
		R_record.setFont(Fonts.myfont_title_bold);
		Record.add(R_record);
		jmb.add(Record);

		Develop=new JMenu("开发");
		Develop.setFont(Fonts.myfont_title_bold);
		D_thinking=new JMenuItem("开发心得");
		D_thinking.setFont(Fonts.myfont_title_bold);
		D_kit=new JMenuItem("开发工具");
		D_kit.setFont(Fonts.myfont_title_bold);
		D_developer=new JMenuItem("开发人员");
		D_developer.setFont(Fonts.myfont_title_bold);
		D_time=new JMenuItem("开发时间");
		D_time.setFont(Fonts.myfont_title_bold);
		Develop.add(D_kit);
		Develop.add(D_developer);
		Develop.add(D_time);
		Develop.add(D_thinking);
		jmb.add(Develop);
		
		this.setJMenuBar(jmb);
		
	}
	//写卡片布局
	public void initCardLayout(){
		cl=new CardLayout();
		jp=new JPanel(cl);
		
		gp=new GameJPanel();
		gp.setPreferredSize(new Dimension(480,360));
		this.setFocusable(true);
		this.addKeyListener(gp);
		
		l=new Loading();
		l.getGameJPanel(gp);
//		l.setBackground(Color.BLACK);

		
		
		sj=new StartJPanel(l);
		jp.add("1",sj);
		ij=new IntroduceJPanel();
		jp.add("2",ij);
		rj=new RecordJPanel();
		jp.add("3",rj);
		dj=new DevelopJPanel();
		jp.add("4",dj);
		
		jp.add("5",l);
		
		jp.add("10",gp);
		this.add(jp);
	}
	//写主界面
	public MainJpanel(){
		music_stop=new SoundRead("stop.wav");
		music_continue=new SoundRead("continue.wav");
		this.setTitle("Running_Iron_Man");
		initJMenuBar();
		initCardLayout();
		this.setSize(480,360);
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		this.setLocation(width/2-260,height/2-240);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==S_stop){
			GameJPanel.stop=true;
			music_stop.audioclip.play();
			GameJPanel.music_bgm_1.audioclip.stop();
		}
		if(e.getSource()==S_continue){
			GameJPanel.stop=false;
			music_continue.audioclip.play();
			GameJPanel.music_bgm_1.audioclip.play();
		}
		if(e.getSource()==S_exit){
			System.exit(0);
		}
	}
}
