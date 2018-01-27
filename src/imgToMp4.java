

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.media.MediaLocator;

import org.jcodec.api.FrameGrab;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Picture;


public class imgToMp4 {
	private int screenWidth = 1280;
	private int screenHeight = 720;
	Random random = new Random();
	ArrayList<Color> random_color_white_black_gray = null;
	long white = Color.white.getRGB();
	long black = Color.black.getRGB();
	long gray = Color.gray.getRGB();
	
	public imgToMp4() {
		random_color_white_black_gray = new ArrayList<Color>();
		random_color_white_black_gray.add(Color.white);
		random_color_white_black_gray.add(Color.black);
		random_color_white_black_gray.add(Color.gray);
	}
	public void doChange(File file , String whatDoYouWantTheMp4FileName) {
		
		File[] files = file.listFiles();
		
		//sort
		Arrays.sort(files, new Comparator<File>(){
		    public int compare(File f1, File f2)
		    {
		        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
		    } 
		});
		
		//변경 vector로
		Vector<String> file_list = new Vector<String>();
		
		for(int i = 0 ; i < files.length ; i ++) {
			file_list.add(file.getAbsolutePath()+"\\"+files[i].getName());
		}
		
		
		int interval = 33;
		
   	    JpegImagesToMovie imageToMovie = new JpegImagesToMovie();
  	    MediaLocator oml;
  	    
   	    if ((oml = imageToMovie.createMediaLocator(whatDoYouWantTheMp4FileName)) == null) {
   	        System.err.println("Cannot build media locator from: " + whatDoYouWantTheMp4FileName);
   	        System.exit(0);
   	    }
   	    
   	    try {
			imageToMovie.doIt(screenWidth, screenHeight, (1000 / interval), file_list, oml);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Vector<String> Mp4ToImg(File mp4File , String outputPath){
		System.out.println("Mp4ToImg");
		//String outputPath="C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\effect\\";
		SeekableByteChannel mp4 = null;
		FrameGrab grab;
		Picture picture;
		
		
		double startSec = 0.0f;
		try{
			
			if(mp4!=null)
				mp4.close();
			mp4 = null;
			grab = null;
			
			
			
			mp4 = NIOUtils.readableChannel(mp4File);
			grab = FrameGrab.createFrameGrab(mp4);
			
			grab = grab.seekToSecondPrecise(startSec);
		 	int count = grab.getVideoTrack().getMeta().getSeekFrames().length;
		    System.out.println("mp4 size : "+mp4.size());
		    
		    int i = 0 ;
			while(true){
			   
				if(i%20 == 0)
					System.out.println("now : "+i);
				
				picture = grab.getNativeFrame();//이게제일좋은듯
				
				if(picture == null)
					break;
				
			    BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
			   
			    
			    
			    String file_new_name = +i+".jpg";
			    ImageIO.write(bufferedImage, "jpg", new File(outputPath+file_new_name));
			    i++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			grab=null;
			mp4 = null;
			picture =null;
			mp4File = null;
		}
		System.out.println("finish Mp4ToImg");
		return null;
	}
	
	int myX = 0;
	int myY = 0;
	int myR = 0;
	int r = 0;
	int g = 0;
	int b = 0;
	
	public void effectBubble(String source , String outputPath) {
		File loadImage = new File(source);
		BufferedImage bi = null;
		
		//bi_temp.setData(raster);
		
		//bi.getSource();
		myX = 0;
		myY = 0;
		myR = 0;
		
		r = 0 ;
		g = 0 ;
		b = 0 ;
		
		
		try{
			
			bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			g2 = bi.createGraphics();
			

			for(int i = 0 ; i < random.nextInt(40)+10 ; i ++){
				myX = random.nextInt(1280);
				myY = random.nextInt(720);
				myR = random.nextInt(100)+30;
				
				for(int x = -myR ; x < myR ; x ++){
					for(int y = -myR ; y < myR ; y ++){
						if(!circle(x,y,myR)){
							//g2.drawRect(i, j, 2, 2);
							if(myX+x>0&myX+x<1280&myY+y>0&myY+y<720){
								Color c = new Color(bi.getRGB(myX+x, myY+y));
								r = c.getRed()+30;
								g = c.getGreen()+30;
								b = c.getBlue()+30;
								if(r>255)r=255;
								if(g>255)g=255;
								if(b>255)b=255;
								g2.setColor(new Color(r,g,b));
								g2.fillRect(myX+x, myY+y, 1, 1);
							}
							//bi.setRGB(i,j, new Color(r,g,b).getRGB());
						}
					}
				}
			}
			
			
			g2.dispose();
			
			
			try{
				
				ImageIO.write(bi, "jpg", new File(outputPath));

			}catch(Exception e){
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public boolean circle( int x , int y , int r ){
		if(x*x+y*y>r*r)
			return true;
		return false;
	}
	
	int start_y;
	int start_x;
	
	public void analog(String source , String destination){
		File loadImage = new File(source);
		BufferedImage bi = null;
		
		r = random.nextInt(255);
		g = random.nextInt(255);
		b = random.nextInt(255);
		try{
			
			bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			g2.setColor(new Color(r,g,b));

			//int x_many = random.nextInt(7)+2;
			start_y = random.nextInt(650)+30;
			start_x = random.nextInt(1200)+50;
			//x_many *= 2;
			//y_many *= 2;
			
			//int previous_x = 0;
			//int previous_y = 0;
			//int current_y = start_y_many;
			//random_color_white_black_gray = null;
			//random_color_white_black_gray = new ArrayList<Color>();
			
			
			for(int j = 0 ; j < random.nextInt(5)+2 ; j++){
				
				for(int i = 0 ; i < 1280 ; i ++){
					g2.setColor(random_color_white_black_gray.get(random.nextInt(3)));
					g2.drawRect(i, start_y, random.nextInt(4)+1, random.nextInt(4)+1);
				}
				start_y = random.nextInt(650)+50;
			}
			
			for(int j = 0 ; j < random.nextInt(5)+2 ; j++){
				
				for(int i = 0 ; i < 720 ; i ++){
					g2.setColor(random_color_white_black_gray.get(random.nextInt(3)));
					g2.drawRect(start_x, i, random.nextInt(4)+1, random.nextInt(4)+1);
				}
				start_x = random.nextInt(1200)+50;
			}
			
			g2.dispose();
			
			
			try{
				
				ImageIO.write(bi, "jpg", new File(destination));

			}catch(Exception e){
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	public void salt_and_pepper(String source , String destination){
		File loadImage = new File(source);
		int size = 2;
		BufferedImage bi = null;
		
		try {
			
			bi = ImageIO.read(loadImage);
			//bi.setRGB(x, y, rgb);
			
			Random random = new Random();
			int many = random.nextInt(200)+50;
			
			
			int width = bi.getWidth();
			int height = bi.getHeight();
			
			//c = new Color(bi.getRGB(i, j));
			
			for(int i = 0 ; i < many ; i ++){
				int ran_width = random.nextInt(width);
				int ran_height = random.nextInt(height);
				
				
				for(int x = -size ; x <= size ; x++){
					for(int y = -size ; y <= size ; y++){
						if(ran_width+x>width-1|ran_width+x<0){
							
						}else{
							if(ran_height+y>height-1|ran_height+y<0){
								
							}else{
								bi.setRGB(ran_width+x, ran_height+y, Color.black.getRGB());
							}
						}
					}
				}
				
				
				ran_width = random.nextInt(width);
				ran_height = random.nextInt(height);
				
				
				
				for(int x = -size ; x <= size ; x++){
					for(int y = -size ; y <= size ; y++){
						if(ran_width+x>width-1|ran_width+x<0){
							
						}else{
							if(ran_height+y>height-1|ran_height+y<0){
								
							}else{
								bi.setRGB(ran_width+x, ran_height+y, Color.white.getRGB());
							}
						}
					}
				}
				
				
				
				
			}
					
			
			try{
				
				ImageIO.write(bi, "jpg", new File(destination));
				//ImageIO.write(bi, "png", destination);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			

		} catch (IOException e) {

			System.out.print("이미지 불러오기 에러 ");

			e.printStackTrace();

		}
	}
	
	int x_many;
	int y_many;
	
	int gab_x;
	int gab_y;
	
	boolean boolean_x;
	boolean boolean_y;
	Color c;
	
	public void checkLine(String source , String destination){
		File loadImage = new File(source);
		BufferedImage bi = null;
		r = random.nextInt(255);
		g = random.nextInt(255);
		b = random.nextInt(255);
		try{
			
			bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			//g2.setColor(new Color(r,g,b));

			x_many = random.nextInt(15)+10;
			y_many = random.nextInt(10)+10;
			
			gab_x = 1280/x_many;
			gab_y = 720/y_many;
			//x_many *= 2;
			//y_many *= 2;
			
			boolean_x = false;
			boolean_y = false;
			//Color c = null;
			for(int i = 1 ; i < 1280 ; i ++){
				if(i%gab_x==0){
					boolean_x=!boolean_x;
				}
				
				for(int j = 0 ; j < 720 ; j++){
					if(j%gab_y==0)
						boolean_y=!boolean_y;
					
					c = new Color(bi.getRGB(i, j));
					if(boolean_x){
						
						r = c.getRed()+30;
						g = c.getGreen()+30;
						b = c.getBlue()+30;
						if(r>255)r=255;
						if(g>255)g=255;
						if(b>255)b=255;
						g2.setColor(new Color(r,g,b));
						g2.fillRect(i, j, 1, 1);
					}
					if(boolean_y){
						c = new Color(bi.getRGB(i, j));
						r = c.getRed()+30;
						g = c.getGreen()+30;
						b = c.getBlue()+30;
						if(r>255)r=255;
						if(g>255)g=255;
						if(b>255)b=255;
						g2.setColor(new Color(r,g,b));
						g2.fillRect(i, j, 1, 1);
					}
					
				}		
			}
			
			/*
			//g2.drawRect(i, j, 2, 2);
			Color c = new Color(bi.getRGB(i, j));
			r = c.getRed()+1;
			g = c.getGreen()+1;
			b = c.getBlue()+1;
			if(r>255)r=255;
			if(g>255)g=255;
			if(b>255)b=255;
			g2.setColor(new Color(r,g,b));
			g2.drawRect(i, j, 1, 1);
			//bi.setRGB(i,j, new Color(r,g,b).getRGB());
			*/		
					
			
			g2.dispose();
			
			
			try{
				
				ImageIO.write(bi, "jpg", new File(destination));

			}catch(Exception e){
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
	
