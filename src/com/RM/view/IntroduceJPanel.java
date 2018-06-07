package com.RM.view;

import javax.swing.*;

import com.RM.ImageIO.ImageName;
import com.RM.ImageIO.ReadImage;
import com.RM.SoundIO.SoundRead;
import com.RM.tools.Fonts;

import java.awt.*;
import java.awt.event.*;

public class IntroduceJPanel extends JPanel implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5;
	JLabel Intro_back;
	MyJButton B_back;
	JPanel jp;//�ѷ��ؼ��������½�
	SoundRead music_button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public IntroduceJPanel(){
		music_button=new SoundRead("button.wav");
		Intro_back=new JLabel(new ImageIcon(new ReadImage(ImageName.Intro_back).getImage(0,0,480,360)));
		Intro_back.setBounds(0,0,480,360);
		jl1=new JLabel("����Ϸ˼·��Դ���ֻ��������");
		jl2=new JLabel("�����,ͬʱ���������С�����");
		jl3=new JLabel("��һ��,ѧϰƣ��֮ʱ�ǵ���һ");
		jl4=new JLabel("��Ŷ������");
		jl5=new JLabel("����               ���̣��ϡ���");
		jl1.setBounds(10,0,480,80);
		jl2.setBounds(10,0,480,160);
		jl3.setBounds(10,0,480,240);
		jl4.setBounds(10,0,480,320);
		jl5.setBounds(10,0,480,400);
		jl1.setForeground(Color.red);//����������ɫ
		jl2.setForeground(Color.red);//����������ɫ
		jl3.setForeground(Color.red);//����������ɫ
		jl4.setForeground(Color.red);//����������ɫ
		jl5.setForeground(Color.red);//����������ɫ
		jl1.setFont(Fonts.myfont_button_bold);
		jl2.setFont(Fonts.myfont_button_bold);
		jl3.setFont(Fonts.myfont_button_bold);
		jl4.setFont(Fonts.myfont_button_bold);
		jl5.setFont(Fonts.myfont_button_bold);
		
		Intro_back.add(jl1);
		Intro_back.add(jl2);
		Intro_back.add(jl3);
		Intro_back.add(jl4);
		Intro_back.add(jl5);
		B_back=new MyJButton(" ��  �� ",290,210);
		B_back.setBounds(300,230,160,45);
		B_back.addActionListener(this);
		Intro_back.add(B_back);
		this.add(Intro_back);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==B_back){
			music_button.audioclip.play();
			MainJpanel.cl.show(this.getParent(),"1");
		}
	}

}
