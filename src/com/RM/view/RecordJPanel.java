package com.RM.view;
import javax.swing.*;

import com.RM.FileIo.*;
import com.RM.ImageIO.ImageName;
import com.RM.ImageIO.ReadImage;
import com.RM.tools.Fonts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.math.*;

public class RecordJPanel extends JPanel implements ActionListener{
	JLabel Record_back=null;
	JLabel JlTitle=null;
	JButton jb=null;
	JLabel jl[]=new JLabel[10];
	Score score=null;
	RecordJPanel(){
		
	}
	RecordJPanel(Score score){
		Record_back=new JLabel(new ImageIcon(new ReadImage(ImageName.Intro_back).getImage(0,0,480,360)));
		Record_back.setBounds(0,0,480,360);
		jb=new JButton("����");
		jb.setBounds(400, 270,60,40);
		jb.addActionListener(this);
		this.score=score;
		Record_back.add(jb);
		JlTitle=new JLabel("                 ���� "+"                           "+"     ����� ");
		JlTitle.setForeground(Color.white);
		JlTitle.setFont(Fonts.myfont_score_title);
		JlTitle.setBounds(10,0,480,30);
		Record_back.add(JlTitle);
		int j=36;//ÿ��label֮��ļ��
      for(int i=0;i<=9;i++){
        	jl[i]=new JLabel("                   "+score.getPath().get(i)+
        			"                                        "
        			+score.getCoinsum().get(i));
        	jl[i].setBounds(10,j,480,15);
        	jl[i].setForeground(Color.green);//����������ɫ
        	jl[i].setFont(Fonts.myfont_score_label);
        	j+=28;
        	Record_back.add(jl[i]);
        }
      this.add(Record_back);
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			MainJpanel.cl.show(this.getParent(),"1");
		}
	}
}
	
	

