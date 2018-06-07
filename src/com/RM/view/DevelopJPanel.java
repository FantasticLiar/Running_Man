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
	JPanel jp;//把返回键放在右下角
	SoundRead music_button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public DevelopJPanel(){
		music_button=new SoundRead("button.wav");
		Develop_back=new JLabel(new ImageIcon(new ReadImage(ImageName.Develop).getImage(0,0,480,360)));
		Develop_back.setBounds(0,0,480,360);
		jl1=new JLabel("开发工具：java");
		jl2=new JLabel("开发人员：李靖、刘恒");
		jl3=new JLabel("开发时间：2016-11-25~2016-12-10");
		jl4=new JLabel("心得：初学java，边学习边做，对自己");
		jl5=new JLabel("有很大提升,对java也产生了浓厚的兴趣，");
		jl6=new JLabel("希望以后能继续学习");
		jl1.setBounds(10,0,480,80);
		jl2.setBounds(10,0,480,160);
		jl3.setBounds(10,0,480,240);
		jl4.setBounds(10,0,480,320);
		jl5.setBounds(10,0,480,400);
		jl6.setBounds(10,0,480,480);
		jl1.setForeground(Color.CYAN);//设置字体颜色
		jl2.setForeground(Color.CYAN);//设置字体颜色
		jl3.setForeground(Color.CYAN);//设置字体颜色
		jl4.setForeground(Color.CYAN);//设置字体颜色
		jl5.setForeground(Color.CYAN);//设置字体颜色
		jl6.setForeground(Color.CYAN);//设置字体颜色
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
		B_back=new MyJButton(" 返  回 ",290,210);
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
