package com.RM.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.RM.ImageIO.ImageName;
import com.RM.ImageIO.ReadImage;
import com.RM.SoundIO.SoundRead;
import com.RM.tools.Fonts;

public class DevelopJPanel extends JPanel implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JLabel Develop_back;
	MyJButton B_back;
	JPanel jp;//�ѷ��ؼ��������½�
	SoundRead music_button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public DevelopJPanel(){
		music_button=new SoundRead("button.wav");
		Develop_back=new JLabel(new ImageIcon(new ReadImage(ImageName.Develop).getImage(0,0,480,360)));
		Develop_back.setBounds(0,0,480,360);
		jl1=new JLabel("�������ߣ�java");
		jl2=new JLabel("������Ա���������");
		jl3=new JLabel("����ʱ�䣺2016-11-25~2016-12-10");
		jl4=new JLabel("�ĵã���ѧjava����ѧϰ���������Լ�");
		jl5=new JLabel("�кܴ�����,��javaҲ������Ũ�����Ȥ��");
		jl6=new JLabel("ϣ���Ժ��ܼ���ѧϰ");
		jl1.setBounds(10,0,480,80);
		jl2.setBounds(10,0,480,160);
		jl3.setBounds(10,0,480,240);
		jl4.setBounds(10,0,480,320);
		jl5.setBounds(10,0,480,400);
		jl6.setBounds(10,0,480,480);
		jl1.setForeground(Color.CYAN);//����������ɫ
		jl2.setForeground(Color.CYAN);//����������ɫ
		jl3.setForeground(Color.CYAN);//����������ɫ
		jl4.setForeground(Color.CYAN);//����������ɫ
		jl5.setForeground(Color.CYAN);//����������ɫ
		jl6.setForeground(Color.CYAN);//����������ɫ
		jl1.setFont(Fonts.myfont_JLabel_bold);
		jl2.setFont(Fonts.myfont_JLabel_bold);
		jl3.setFont(Fonts.myfont_JLabel_bold);
		jl4.setFont(Fonts.myfont_JLabel_bold);
		jl5.setFont(Fonts.myfont_JLabel_bold);
		jl6.setFont(Fonts.myfont_JLabel_bold);
		
		Develop_back.add(jl1);
		Develop_back.add(jl2);
		Develop_back.add(jl3);
		Develop_back.add(jl4);
		Develop_back.add(jl5);
		Develop_back.add(jl6);
		B_back=new MyJButton(" ��  �� ",290,210);
		B_back.setBounds(300,230,160,45);
		B_back.addActionListener(this);
		Develop_back.add(B_back);
		this.add(Develop_back);
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
