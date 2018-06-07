package com.RM.FileIo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreFile1 {
	File f=null;
	private ArrayList<Score1> Scores=new ArrayList<Score1>();
	//输入1，按距离长度排序，输入2，按金币数排序
	public void setOrderByCoinsum(int temp){
		for(int i=0;i<Scores.size();i++){
			if(temp==1){
				Score1 temp1=Scores.get(i);
				for(int j=i+1;j<Scores.size();j++){
					Score1 temp2=Scores.get(j);
					if(temp1.getPath()<temp2.getPath()){
						Score1 temp3=new Score1();
						temp3=temp1;
						temp1=temp2;
						temp2=temp3;
					}
				}
			}else if(temp==2){
				Score1 temp1=Scores.get(i);
				for(int j=i+1;j<Scores.size();j++){
					Score1 temp2=Scores.get(j);
					if(temp1.getCoinsum()<temp2.getCoinsum()){
						Score1 temp3=new Score1();
						temp3=temp1;
						temp1=temp2;
						temp2=temp3;
					}
				}
			}
		}
	}
	public void writeData(){
		
	}
	public void readData(){
		//文件取出字符流对象(输入流)
		FileReader fr=null;
		//文件写入字符流对象（输出流）
		FileWriter fw=null;	
		try {
			f=new File(".");
			//创建一个读入fr对象
			fr=new FileReader("E:\\Android\\文件.txt");
			//创建一个输出fw对象
			fw=new FileWriter("E:\\Android\\java创建的文件夹\\文件.txt");
			//读入到内存，使用char（2字节），而不用byte（1字节），因为一个汉字是俩个字节
			char buf[]=new char[1024];
			//记录实际读取到的字符数
			int n=0;
			while((n=fr.read(buf))!=-1)
			{
//				String s=new String(buf,0,n);
//				System.out.println(s);
//				fw.write(buf);
				//俩个write的区别：上面的write会将buf后面的空地址也拷贝过去，而下面的只拷贝有的字符
				fw.write(buf,0,n);
			}
		} catch (Exception e) {
				e.printStackTrace();	
		}finally{
			try {
				fr.close();
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
