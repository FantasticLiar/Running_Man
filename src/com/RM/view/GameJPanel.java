package com.RM.view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

import com.RM.ImageIO.ImageName;
import com.RM.ImageIO.ReadImage;
import com.RM.SoundIO.SoundRead;
import com.RM.model.*;
import com.RM.tools.Globle;

public class GameJPanel extends JPanel implements Runnable,KeyListener{
	Image Background;
	ArrayList<Image> Run=null,Jump=null;//�����ܶ�����
	BufferedImage paint;
	BufferedImage Characters;
	ManageCoin mc=null;
	ManageStones ms=null;
	static boolean stop=false;
	boolean GameOver=false;
	final int character_x=100,character_y=185;
	int Run_or_Jump=0;//0��run��1��jump
	int temp1=0,temp2=0;//�����ܺ�����ʱ��
	int temp_run=0,temp_jump=0;
	int Jump_y=0;//��Ծ�ĸ߶ȱ仯
	int temp_distance;//ÿ����Ծ�߶�
	int temp_time=0;//ÿ��40�����ص�λ����һ��ʯͷ���߽��
	static int score_coin=0;
	static int length=0;
	static SoundRead music_bgm_1;
	SoundRead music_failure,music_coin;
	private int x=0;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public GameJPanel(){
		mc=new ManageCoin();
		ms=new ManageStones();
		music_bgm_1=new SoundRead("bgm_1.wav");
		music_failure=new SoundRead("failure.wav");
		music_coin=new SoundRead("coin.wav");
		//�õ��˶�������
		getCharactersList();
	}
	public void paint(Graphics g){
		super.paintComponent(g);
	     // ����һ��������
		paint = new BufferedImage(480,360,
              BufferedImage.TYPE_3BYTE_BGR);
		// �õ��������Ļ���
		Graphics g2 = paint.getGraphics();
		// ����Ҫ���Ƶ�ͼ�λ��Ƶ�������

		drawBackground(g2);
		drawObstacles(g2);
//		drawStones(g);
		if(Run_or_Jump==0){
			drawRun(g2);
		}else{
			drawJump(g2);
		}
		// ����������ͼ�λ��Ƶ���ʾ�����
		g.drawImage(paint,0, 0,480,360, this);
	}
	public void getCharactersList(){
		Run=new ArrayList<Image>();
		Jump=new ArrayList<Image>();
		Characters=new ReadImage(ImageName.Actions3).getSourImage();
		Run.add(Characters.getSubimage(30, 60,49,49));
		Run.add(Characters.getSubimage(72, 60,49,49));
		Run.add(Characters.getSubimage(119,60,49,49));
		Jump.add(Characters.getSubimage(170,110,49,49));
		Jump.add(Characters.getSubimage(215,110,49,49));
		Jump.add(Characters.getSubimage(215,110,49,49));
		Jump.add(Characters.getSubimage(298,60,49,49));
		Jump.add(Characters.getSubimage(130,110,49,49));
		Jump.add(Characters.getSubimage(215,110,49,49));
	}
	public void drawObstacles(Graphics g){
		temp_time++;
		if(temp_time==20){
			temp_time=0;
			int i=(int)(Math.random()*3);
			if(i==1){
				ms.createStones();//����ʯͷ
			}else{
				mc.createCoin();//�����
			}
		}
		mc.Move_Draw_Judge(g);	
		ms.Move_Draw_Judge(g);
	}
//	public void drawStones(Graphics g){
//		
//	}
	public void drawRun(Graphics g){
		g.drawImage(Run.get(temp_run),character_x,character_y, this);
		if(temp1++==2){
			temp1=0;
			temp_run++;
			if(temp_run>=Run.size()-1){
				temp_run=0;
			}
		}
	}
	public void drawJump(Graphics g){
		g.drawImage(Jump.get(temp_jump),character_x,character_y-Jump_y, this);
			if(Jump_y==48){	
				temp_distance=-4;
				Jump_y+=temp_distance;
			}if(Jump_y==0){	
				temp_distance=4;
				Jump_y+=temp_distance;
			}else
				Jump_y+=temp_distance;
			if(temp2++==4){
				temp_jump++;
				temp2=0;
				if(temp_jump==Jump.size()-1){
					temp_jump=0;
					Run_or_Jump=0;//�����˾���
					Jump_y=0;
			}
		}
	}					
	//�ж��Ƿ�ͽ�ҡ�ʯͷ��ײ�ĺ���
	public int isCollide(){
		int flag=0;//0��û��ײ��1�������˽�ң�2��������ʯͷ
		for(int i=0;i<mc.myCoinList.size();i++){
			coin coin=mc.myCoinList.get(i);
			if(coin.getX()<(character_x+49)&&coin.getX()>character_x){
				if(coin.getY()>(character_y-Jump_y)&&coin.getY()<character_y+60){
					flag=1;
					score_coin++;
					music_coin.audioclip.play();
					mc.myCoinList.remove(coin);
					return flag;
				}	
			}else if((coin.getX()+49)<(character_x+60)&&(coin.getX()+49)>character_x){
				if(coin.getY()>(character_y-Jump_y)&&coin.getY()<character_y-Jump_y+60){
					flag=1;
					score_coin++;
					music_coin.audioclip.play();
					mc.myCoinList.remove(coin);
					return flag;
				}
			}
		}
		for(int j=0;j<ms.myStonesList.size();j++){
			stones stones=ms.myStonesList.get(j);
			if(stones.getX()+10<(character_x+35)&&stones.getX()+10>character_x+10){
				if(stones.getY()+10>(character_y-Jump_y)&&stones.getY()+10<character_y-Jump_y+40){
					flag=2;
					return flag;
				}	
			}else if((stones.getX()-18+49)<(character_x+40)&&(stones.getX()-18+49)>character_x){
				if(stones.getY()+15>(character_y-Jump_y)&&stones.getY()+15<character_y-Jump_y+40){
					flag=2;
					return flag;
				}
			}
		}
		return flag;
	}
	//������
	public void drawBackground(Graphics g){
		if(x>=658-480){
			x=0;
		}
		Background=new ReadImage(ImageName.Game_back1).getSourImage();//��Ϸ���н���ı���
//	      // ����һ��������
//        paint = new BufferedImage(462,300,
//                BufferedImage.TYPE_3BYTE_BGR);
//        // �õ��������Ļ���
//        Graphics g2 = paint.getGraphics();
//        // ����Ҫ���Ƶ�ͼ�λ��Ƶ�������
//        g2.drawImage(Background,0, 0, 462,300,this);
//        // ����������ͼ�λ��Ƶ���ʾ�����
//        g.drawImage(paint,0, 0,462,300, this);
//		Background =new ImageIcon(ImageName.Game_back).getImage();
//		Graphics2D g2d=(Graphics2D)g;
		g.drawImage(Background,0,0,480,360,x,0,x+480,360,this.getRootPane());
        x+=Globle.Speed;
	}
	public void reStartGame(){
		//��ʼ����Ϸ����
		Characters=null;
		x=0;//���»���ͼ
		score_coin=0;
		length=0;
		GameOver=false;
		Run_or_Jump=0;//0��run��1��jump
		temp1=0;temp2=0;//�����ܺ�����ʱ��
		temp_run=0;temp_jump=0;
		Jump_y=0;//��Ծ�ĸ߶ȱ仯
		temp_distance=2;//ÿ����Ծ�߶�
		temp_time=0;//ÿ��40�����ص�λ����һ��ʯͷ���߽��
		ms.myStonesList.clear();
		mc.myCoinList.clear();
	}
	public void run(){
		music_bgm_1.audioclip.loop();
		while(!GameOver){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(stop){
				
			}else{
				GameOver=(isCollide()==2)?true:false;
				length+=2;
				this.repaint();
			}
		}
		music_bgm_1.audioclip.stop();
		music_failure.audioclip.play();
		int choice=JOptionPane.showConfirmDialog(null,"���ź��������ˣ��Ƿ�������һ�֣�","GameOver",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		reStartGame();
		if(choice==0){
			Thread t=new Thread(this);
			t.start();
			MainJpanel.cl.show(getParent(), "10");
		}else{
			MainJpanel.cl.show(this.getParent(),"1");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			Run_or_Jump=1;
		}
//		if(e.getKeyCode()==KeyEvent.VK_DOWN)
//		{
//			Run_or_Jump=0;
//			System.out.println("aaaaaaaaaa");
//		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
