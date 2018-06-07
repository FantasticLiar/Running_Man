package com.RM.FileIo;

import java.awt.Image;
import java.util.ArrayList;

public class Score{
	private ArrayList<Integer> coinsum=null;
	private ArrayList<Integer> path=null;
	public Score(ArrayList<Integer> path,ArrayList<Integer> coinsum){
		this.path=path;
		this.coinsum=coinsum;
	}
	public ArrayList<Integer> getPath() {
		return path;
	}
	public void setPath(ArrayList<Integer> path) {
			this.path = path;
    }
	
	public ArrayList<Integer> getCoinsum() {
		return coinsum;
	}
	public void setCoinsum(ArrayList<Integer> coinsum) {
		this.coinsum = coinsum;
	}	
}
