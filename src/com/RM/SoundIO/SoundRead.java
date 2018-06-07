package com.RM.SoundIO;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

//≤•∑≈“Ù¿÷

public class SoundRead extends JApplet{
//	final String dir="file:/E:/Android/Running_man/Running_man/music/";
	public AudioClip audioclip;
	public SoundRead(String path)
	{
		String dir="file:\\"+System.getProperty("user.dir")+"\\music\\";
		String music_path=dir+path;
		try
		{
			audioclip=Applet.newAudioClip(new URL(music_path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
