package com.RM.FileIo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreFile1 {
	File f=null;
	private ArrayList<Score1> Scores=new ArrayList<Score1>();
	//����1�������볤����������2�������������
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
		//�ļ�ȡ���ַ�������(������)
		FileReader fr=null;
		//�ļ�д���ַ��������������
		FileWriter fw=null;	
		try {
			f=new File(".");
			//����һ������fr����
			fr=new FileReader("E:\\Android\\�ļ�.txt");
			//����һ�����fw����
			fw=new FileWriter("E:\\Android\\java�������ļ���\\�ļ�.txt");
			//���뵽�ڴ棬ʹ��char��2�ֽڣ���������byte��1�ֽڣ�����Ϊһ�������������ֽ�
			char buf[]=new char[1024];
			//��¼ʵ�ʶ�ȡ�����ַ���
			int n=0;
			while((n=fr.read(buf))!=-1)
			{
//				String s=new String(buf,0,n);
//				System.out.println(s);
//				fw.write(buf);
				//����write�����������write�Ὣbuf����Ŀյ�ַҲ������ȥ���������ֻ�����е��ַ�
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
