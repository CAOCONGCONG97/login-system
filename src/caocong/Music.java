package caocong;

 import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
public class Music extends JFrame{ 
   File f;
   URI uri;
   URL url; 
 Music(){  
   try {      
       f = new File("1.wav"); 
       uri = f.toURI();
       url = uri.toURL();  //解析地址
       AudioClip aau; 
       aau = Applet.newAudioClip(url);
       aau.loop();  //循环播放
   } catch (Exception e) 
   { e.printStackTrace();
   } 
 }

 }