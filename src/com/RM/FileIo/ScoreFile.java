package com.RM.FileIo;
import java.io.*;
import java.util.ArrayList;

public class ScoreFile {
	File f=null;
	ArrayList<Integer> path=new ArrayList<Integer>();
	ArrayList<Integer> coinsum=new ArrayList<Integer>();
	
	public ScoreFile(){	
	}
	//分数按照跑的步数排序
	public Score setOrderByPath(Score score){
		for(int i=0;i<score.getPath().size();i++){
			for(int j=i+1;j<score.getPath().size();j++){
				if(score.getPath().get(i)>score.getPath().get(j)){
					int temp1=score.getPath().get(i);
					int temp2=score.getCoinsum().get(i);
					score.getPath().set(i,score.getPath().get(j));
					score.getCoinsum().set(i, score.getCoinsum().get(j));
					score.getPath().set(j, temp1);
					score.getCoinsum().set(j, temp2);
					}
			}
		}
		return score;
	}
	//读取文件中的值，存入score中
	public Score ScoreRead() throws Exception {
		 FileReader fr = new FileReader("f:/分数.txt");
		    try {
		        int i=0,tmp=0,k=0;
		        int flag=0,time=0;
		        int j[]=new int[100];
		        while ((i = fr.read()) != -1){
		        	if(i>=48){
		        	j[k]=i-48;
		        	k++;
		        	flag=1;
//		        	continue;
		        	}else
		        	{
		        	  if(flag==1){
		        	  for(int p=0;p<=k-1;p++){
		        		  tmp=10*tmp+(j[p]);
		        	   }
		        	  if(time%2==0){
		              path.add(tmp);
		              }else{
		              coinsum.add(tmp); 
		        	  }
		        	  tmp=0;time++;
		        	  for(int p=0;p<=k-1;p++){
		        		  j[p]=0;
		        	   }
		        	  flag=0;
		        	  }
		        	}	              
	            }

		    } finally {
		        fr.close();
		    }
		  Score a=new Score(path,coinsum);  
          return a; 
	}
	
	private static final String LINE_SEPARATOR = 
			System.getProperty("line.separator");//常量，表示空格
	//将记录在score对象中的分数写入文件
	public void ScoreWrite(Score s) {
		    //清空原数据
	   		try {
				FileOutputStream out = new FileOutputStream("d:/分数.txt",false); 
				out.write(new String("").getBytes()); 
				out.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	   		//写入新数据
	        FileWriter fw = null;  
	        try {  
	            fw = new FileWriter("f:/分数.txt", true);
	            
	            for(int i=0;i<=s.getPath().size();i=i+1){
	            fw.write(s.getPath().get(s.getPath().size()-i-1) +"  "
	            +s.getCoinsum().get(s.getPath().size()-i-1)+LINE_SEPARATOR); 
	            }
	        } catch (Exception e) {  
	            System.out.println(e.toString());  
	        } finally {  
	            if (fw != null)  
	                try {  
	                    fw.close();  
	                } catch (IOException e) {  
	                    throw new RuntimeException("关闭失败！");  
	                }  
	        }  
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	}

}
