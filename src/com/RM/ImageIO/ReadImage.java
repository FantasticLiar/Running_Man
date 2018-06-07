package com.RM.ImageIO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//读取项目中的图片资源
public class ReadImage {

	public BufferedImage sourImage;
	
	
	public BufferedImage getSourImage() {
		return sourImage;
	}

	public void setSourImage(BufferedImage sourImage) {
		this.sourImage = sourImage;
	}

	//构造函数
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
	//获取图片的Image对象 x,y,w,h 表示起始横纵坐标 图片宽高
	public Image getImage(int x,int y,int w,int h)
	{
		BufferedImage sour=sourImage.getSubimage(x, y, w, h);//获取图片一部分数据
		Image image=new ImageIcon(sour).getImage();
		return image;		
	}
}
