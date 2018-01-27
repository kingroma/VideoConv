

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;

import javax.media.Buffer;
import javax.media.Controller;
import javax.media.ControllerListener;
import javax.media.Time;
import javax.media.bean.playerbean.MediaPlayer;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

import com.sun.media.ui.PlayerWindow;
import com.sun.media.util.BufferToBufferedImage;

public class getMedia {
	String path ="C:/Users/Andrew/Desktop/skins.avi";
	String fileURL = "file:///"+path;
	MediaPlayer player = new MediaPlayer();
	//player.setMediaLocation(new java.lang.String("file:///"+path));
	public getMedia() throws ClassNotFoundException{
		System.out.println("AVI info test");
		
		init();
	}
	
	public void init(){
		player.setMediaLocation(fileURL);
		
		System.out.println(player.getMediaLocation());
		System.out.println(player.getVolumeLevel());
		System.out.println(player.createImage(10, 10));
		
	}
}
