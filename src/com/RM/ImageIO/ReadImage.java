package com.RM.ImageIO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//��ȡ��Ŀ�е�ͼƬ��Դ
public class ReadImage {

	public BufferedImage sourImage;
	
	
	public BufferedImage getSourImage() {
		return sourImage;
	}

	public void setSourImage(BufferedImage sourImage) {
		this.sourImage = sourImage;
	}

	//���캯��
	public ReadImage(String imagePath)	
	{
		try
		{
			sourImage=ImageIO.read(new File(imagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	//��ȡͼƬ��Image���� x,y,w,h ��ʾ��ʼ�������� ͼƬ���
	public Image getImage(int x,int y,int w,int h)
	{
		BufferedImage sour=sourImage.getSubimage(x, y, w, h);//��ȡͼƬһ��������
		Image image=new ImageIcon(sour).getImage();
		return image;		
	}
}
