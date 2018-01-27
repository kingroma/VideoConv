import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.ConstantDescriptor;
import javax.media.jai.operator.MosaicDescriptor;
import javax.media.jai.operator.TranslateDescriptor;



public class effectImgUpgrade {
	String path = "C:/Users/Andrew/Desktop/output"; 
	File file = new File(path);
	BufferedImage img;
	String filename = path+"/frame_600_0.png"; // ������ ���
	String tempFile = path+"/temp";
	
	int originalWidth = 1280;//�⺻��������
	int originalHeight = 720;//�⺻���� 
	
	Random random = new Random();
	//üũ�����ֱ�
	public effectImgUpgrade(){
		
	//	setBackground(filename,tempFile+"/background.png",path+"/frame_960_1.png");
	}
	
	public void dig(BufferedImage bi , String destination){
		//File loadImage = new File(source);
		//BufferedImage bi = null;
		
		int myX = random.nextInt(1000);
		int myY = random.nextInt(600);
		int myWidth = random.nextInt(100)+50;
		int myHeight = random.nextInt(100)+50;
		Color white = Color.WHITE;
		
		try{
			
			//bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			g2.setColor(white);
			for(int count = 0 ; count < 1+random.nextInt(5) ; count ++){
				
				for(int x = myX ; x < myX+myWidth ; x ++){
					for(int y = myY ; y < myY+myHeight ; y++){
						if(x<1280){
							if(y<720){
								g2.fillRect(x, y, 1, 1);							
							}
						}
					}
				}
				myX = random.nextInt(1100);
				myY = random.nextInt(650);
				myWidth = random.nextInt(200)+50;
				myHeight = random.nextInt(200)+50;
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
	
	public void bubble(BufferedImage bi , String destination){
		//File loadImage = new File(source);
		//BufferedImage bi = null;
		
		int myX = 0;
		int myY = 0;
		int myR = 0;
		
		int r = 0 ;
		int g = 0 ;
		int b = 0 ;
		
		try{
			
			//bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			

			for(int i = 0 ; i < random.nextInt(40)+10 ; i ++){
				myX = random.nextInt(1280);
				myY = random.nextInt(720);
				myR = random.nextInt(150)+30;
				
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
				
				ImageIO.write(bi, "jpg", new File(destination));

			}catch(Exception e){
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void analog(BufferedImage bi , String destination){
		//File loadImage = new File(source);
		//BufferedImage bi = null;
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		try{
			
			//bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			g2.setColor(new Color(r,g,b));

			//int x_many = random.nextInt(7)+2;
			int start_y = random.nextInt(650)+30;
			int start_x = random.nextInt(1200)+50;
			//x_many *= 2;
			//y_many *= 2;
			
			//int previous_x = 0;
			//int previous_y = 0;
			//int current_y = start_y_many;
			
			ArrayList<Color> random_color_white_black_gray = new ArrayList<Color>();
			
			random_color_white_black_gray.add(new Color(Color.white.getRGB()));
			random_color_white_black_gray.add(new Color(Color.black.getRGB()));
			random_color_white_black_gray.add(new Color(Color.gray.getRGB()));
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
	
	public void setCheckLine(BufferedImage bi , String destination){
		//File loadImage = new File(source);
		//BufferedImage bi = null;
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		try{
			
			//bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			//g2.setColor(new Color(r,g,b));

			int x_many = random.nextInt(15)+10;
			int y_many = random.nextInt(10)+10;
			
			int gab_x = 1280/x_many;
			int gab_y = 720/y_many;
			//x_many *= 2;
			//y_many *= 2;
			
			boolean boolean_x = false;
			boolean boolean_y = false;
			Color c = null;
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
	
	public void setCheck(BufferedImage bi, String destination){
		//File loadImage = new File(source);
		//BufferedImage bi = null;
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		try{
			
			//bi = ImageIO.read(loadImage);
			Graphics2D g2 = null;
			
			g2 = bi.createGraphics();
			g2.setColor(new Color(r,g,b));

			int x_many = random.nextInt(7)+2;
			int y_many = random.nextInt(7)+1;
			
			//x_many *= 2;
			//y_many *= 2;
			
			
			
			for(int i = 0 ; i < 1280 ; i ++){
				for(int j = 0 ; j < 720 ; j++){
					
					if(i%3%2==0){
						if(j%3%2==0){
							//g2.drawRect(i, j, 2, 2);
							Color c = new Color(bi.getRGB(i, j));
							r = c.getRed()+10;
							g = c.getGreen()+10;
							b = c.getBlue()+10;
							if(r>255)r=255;
							if(g>255)g=255;
							if(b>255)b=255;
							g2.setColor(new Color(r,g,b));
							g2.drawRect(i, j, 1, 1);
							//bi.setRGB(i,j, new Color(r,g,b).getRGB());
						}
					}
					
				}
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
	public void setDrawImgCircle(String source,String destination,BufferedImage bi2){
		File loadImage = new File(source);
		//File loadImage2 = new File(background);
		
		BufferedImage bi = null;
		//BufferedImage bi2 = null;
		
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		
		
		try {
			
			bi = ImageIO.read(loadImage);
			//bi2 = ImageIO.read(loadImage2);
			
			int width = bi.getWidth();
			int height = bi.getHeight();
			
			int width2 = bi2.getWidth();
			int height2 = bi2.getHeight();
			
			
			//c = new Color(bi.getRGB(i, j));
			Graphics2D g2 = null;
			
			g2 = bi2.createGraphics();
			g2.clearRect(0, 0, width2, height2);
			//g2.setBackground(new Color(r,g,b));
			g2.setColor(new Color(r,g,b));
			g2.fillRect(0, 0, width2, height2);
			
			
			//ũ�� ���� �ϴ� ���� ��
			double resize_value1 = random.nextInt(2)+1;
			double resize_value2 = random.nextInt(2)+resize_value1+1;
			//System.out.println(resize_value1+"/"+resize_value2);
			double resize_value= resize_value1 /resize_value2;
			double resize_value_invert = resize_value2 / resize_value1;
			//System.out.println(resize_value+"/"+resize_value_invert);
			int resize_width = (int) Math.round(1280*resize_value);
			int resize_height = (int)(720*resize_value);
			//System.out.println(resize_width+"/"+resize_height);
			int margin_left = random.nextInt((int)(1280*resize_value_invert)/5);
			int margin_top = random.nextInt((int)(720*resize_value_invert)/5);
			g2.drawImage(
					resise(source , resize_width,resize_height),
					0+margin_left, 0+margin_top, resize_width, resize_height,null);
			

			//Math.sqrt(10);			
			//�� �׸���
			g2.setColor(new Color(r,g,b));
			//f(x) = x^2 + y^2 = r^2
			
			
			
			int my_r = resize_height/2+random.nextInt(50);
			int my_rr = my_r*my_r;
			int x = resize_width/2;
			int y = resize_height/2;
			
			for(int i = -x ; i < x ; i ++){
				for(int j = -y ; j < y ; j ++){
						if(circle(i,j,my_r)){
							g2.drawRect(i+margin_left+x, j+margin_top+y, 2, 2);
							//System.out.println("i * i = "+i*i+"j * j = "+j+"my_rr = "+my_rr);
						}
						//System.out.println("i * i = "+i*i+"j * j = "+j*j+"my_rr = "+my_rr);
				}
			}
			
			g2.dispose();
			
					
			
			try{
				
				ImageIO.write(bi2, "jpg", new File(destination));
				//ImageIO.write(bi, "png", destination);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			

		} catch (IOException e) {

			System.out.print("�̹��� �ҷ����� ���� ");

			e.printStackTrace();

		}
	}
	
	public boolean rhombus(int x , int y){
		//y=x+b
		return false;
	}
	
	public boolean circle( int x , int y , int r ){
		if(x*x+y*y>r*r)
			return true;
		return false;
	}
	
	public void setBackground(String source, String destination,String background){
		File loadImage = new File(source);
		//File loadImage2 = new File(background);
		
		BufferedImage bi = null;
		BufferedImage bi2 = null;
		try {
			
			bi = ImageIO.read(loadImage);
			//bi2 = ImageIO.read(loadImage2);
			
			int width = bi.getWidth();
			int height = bi.getHeight();
			
			int width2 = bi2.getWidth();
			int height2 = bi2.getHeight();
			
			
			//c = new Color(bi.getRGB(i, j));
			Graphics2D g2 = null;

			g2 = bi2.createGraphics();
			
			
			//ũ�� ���� �ϴ� ���� ��
			
			int resize_width = 1280/2;
			int resize_height = 720/2;
			
			g2.drawImage(
					resise(source , resize_width,resize_height),
					0, 0, resize_width, resize_height,null);
			
			  
			g2.dispose();
			
					
			
			try{
				
				ImageIO.write(bi2, "jpg", new File(destination));
				//ImageIO.write(bi, "png", destination);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			

		} catch (IOException e) {

			System.out.print("�̹��� �ҷ����� ���� ");

			e.printStackTrace();

		}
	}
	public void setBackground_random(String source, String destination,BufferedImage bi2){
		File loadImage = new File(source);
		//File loadImage2 = new File(background);
		
		BufferedImage bi = null;
		//BufferedImage bi2 = null;
		
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		
		
		try {
			
			bi = ImageIO.read(loadImage);
			//bi2 = ImageIO.read(loadImage2);
			
			int width = bi.getWidth();
			int height = bi.getHeight();
			
			int width2 = bi2.getWidth();
			int height2 = bi2.getHeight();
			
			
			//c = new Color(bi.getRGB(i, j));
			Graphics2D g2 = null;
			
			g2 = bi2.createGraphics();
			g2.clearRect(0, 0, width2, height2);
			//g2.setBackground(new Color(r,g,b));
			g2.setColor(new Color(r,g,b));
			g2.fillRect(0, 0, width2, height2);
			
			
			//ũ�� ���� �ϴ� ���� ��
			double resize_value1 = random.nextInt(2)+1;
			double resize_value2 = random.nextInt(2)+resize_value1+1;
			//System.out.println(resize_value1+"/"+resize_value2);
			double resize_value= resize_value1 /resize_value2;
			double resize_value_invert = resize_value2 / resize_value1;
			//System.out.println(resize_value+"/"+resize_value_invert);
			int resize_width = (int) Math.round(1280*resize_value);
			int resize_height = (int)(720*resize_value);
			//System.out.println(resize_width+"/"+resize_height);
			int margin_left = random.nextInt((int)(1280*resize_value_invert)/5);
			int margin_top = random.nextInt((int)(720*resize_value_invert)/5);
			g2.drawImage(
					resise(source , resize_width,resize_height),
					0+margin_left, 0+margin_top, resize_width, resize_height,null);
			
			  
			g2.dispose();
			
					
			
			try{
				
				ImageIO.write(bi2, "jpg", new File(destination));
				//ImageIO.write(bi, "png", destination);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			

		} catch (IOException e) {

			System.out.print("�̹��� �ҷ����� ���� ");

			e.printStackTrace();

		}
	}
	
	public void invert(String source ,String destination){
		File loadImage = new File(source);
		int size = 2;
		BufferedImage bi = null;

		try {
			
			bi = ImageIO.read(loadImage);
			//bi.setRGB(x, y, rgb);
			
			Random random = new Random();
			
			
			
			int width = bi.getWidth();
			int height = bi.getHeight();
			
			//c = new Color(bi.getRGB(i, j));
			
			for(int i = 0 ; i < width ; i ++){
				for(int j = 0 ; j < height ; j ++){
					Color c = new Color(bi.getRGB(i, j));
					
					int r = c.getRed();
					int g = c.getGreen();
					int b = c.getBlue();
					
					r = 255-r;
					g = 255-g;
					b = 255-b;
					
					bi.setRGB(i, j, new Color(r,g,b).getRGB());
					
				}
			}
					
			
			try{
				
				ImageIO.write(bi, "jpg", new File(destination));
				//ImageIO.write(bi, "png", destination);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			

		} catch (IOException e) {

			System.out.print("�̹��� �ҷ����� ���� ");

			e.printStackTrace();

		}
	}
	
	
	public void salt_and_pepper(BufferedImage bi, String destination,int many){
		//File loadImage = new File(source);
		int size = 2;
		//BufferedImage bi = null;

		Random random = new Random();
		
		
		
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
	}
	public void salt_and_pepper_random(BufferedImage bi , String destination){
		//File loadImage = new File(source);
		int size = 2;
		//BufferedImage bi = null;
		
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
	}
	public void light_black(BufferedImage bi , String destination,int value){
		//File loadImage = new File(source);

		//BufferedImage bi = null;

		Color c = new Color(1,1,1,1);
		
		//bi = ImageIO.read(loadImage);
		//bi.setRGB(x, y, rgb);
		
		int how = value;
		
		for(int i = 0 ; i < bi.getWidth() ; i++){
			for(int j = 0 ; j < bi.getHeight() ; j ++){
				c = new Color(bi.getRGB(i, j));
				
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				if(red-how>=0)
					red-=how;
				else red=0;
				
				if(green-how>=0)
					green-=how;
				else green=0;
				
				if(blue-how>=0)
					blue-=how;
				else blue=0;
				
				Color c_temp = new Color(red,green,blue);
				
				bi.setRGB(i, j, c_temp.getRGB());
				
			}
		}
		try{
			
			ImageIO.write(bi, "jpg", new File(destination));
			//ImageIO.write(bi, "png", destination);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void light_black_random(BufferedImage bi , String destination){
		//File loadImage = new File(source);

		Color c = new Color(1,1,1,1);
		
		//bi = ImageIO.read(loadImage);
		//bi.setRGB(x, y, rgb);
		
		int how = random.nextInt(100);
		
		for(int i = 0 ; i < bi.getWidth() ; i++){
			for(int j = 0 ; j < bi.getHeight() ; j ++){
				c = new Color(bi.getRGB(i, j));
				
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				if(red-how>=0)
					red-=how;
				else red=0;
				
				if(green-how>=0)
					green-=how;
				else green=0;
				
				if(blue-how>=0)
					blue-=how;
				else blue=0;
				
				Color c_temp = new Color(red,green,blue);
				
				bi.setRGB(i, j, c_temp.getRGB());
				
			}
		}
		try{
			
			ImageIO.write(bi, "jpg", new File(destination));
			//ImageIO.write(bi, "png", destination);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void light_white(BufferedImage bi , String destination , int value){
		//File loadImage = new File(source);

		//BufferedImage bi = null;

		Color c =null;
		
		//bi = ImageIO.read(loadImage);
		//bi.setRGB(x, y, rgb);
		
		int how = value;
		int max = 255;
		for(int i = 0 ; i < bi.getWidth() ; i++){
			for(int j = 0 ; j < bi.getHeight() ; j ++){
				c = new Color(bi.getRGB(i, j));
				
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				//System.out.println(red);
				if(red+how<=max)
					red+=how;
				else red=max;
				
				if(green+how<=max)
					green+=how;
				else green=max;
				
				if(blue+how<=max)
					blue+=how;
				else blue=max;
				
				Color c_temp = new Color(red,green,blue);
				
				bi.setRGB(i, j, c_temp.getRGB());
				
			}
		}
		try{
			
			ImageIO.write(bi, "jpg", new File(destination));
			//ImageIO.write(bi, "png", destination);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void light_white_random(BufferedImage bi , String destination){
		//File loadImage = new File(source);

		//BufferedImage bi = null;

		Color c =null;
		
		//bi = ImageIO.read(loadImage);
		//bi.setRGB(x, y, rgb);
		
		int how = random.nextInt(100);
		int max = 255;
		for(int i = 0 ; i < bi.getWidth() ; i++){
			for(int j = 0 ; j < bi.getHeight() ; j ++){
				c = new Color(bi.getRGB(i, j));
				
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				//System.out.println(red);
				if(red+how<=max)
					red+=how;
				else red=max;
				
				if(green+how<=max)
					green+=how;
				else green=max;
				
				if(blue+how<=max)
					blue+=how;
				else blue=max;
				
				Color c_temp = new Color(red,green,blue);
				
				bi.setRGB(i, j, c_temp.getRGB());
				
			}
		}
		try{
			
			ImageIO.write(bi, "jpg", new File(destination));
			//ImageIO.write(bi, "png", destination);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	//�۾����� 
	public void makeParagraph(BufferedImage bi, String destination , String text , int width,int height){
		  Font font = new Font("Gungsuh", Font.BOLD, 45);
		  long startTime = System.currentTimeMillis();


		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		  Date date = new Date();

		  File makeImage = new File(destination);

		  //File loadImage = new File(source);

		  //BufferedImage bi = null;

		  

		  int imgWidth = bi.getWidth();

		  int imgHeight = bi.getHeight();


		  Graphics2D g2 = null;

		  g2 = bi.createGraphics();

		  g2.setColor(Color.black);

		  g2.setFont(font);

		  
		  g2.drawString(text, width, height);
		  //g2.drawString(subject, 430, 503);
		  g2.dispose();

		  try {

		   ImageIO.write(bi, "jpg", makeImage);

		  } catch (IOException e) {

		   System.out.print("���ο� �̹��� ���� ���� ");

		   e.printStackTrace();

		  }



	}
	
	String random_text[]={"�ȳ��ϼ���","��ſ��Ϸ��Դϴ�.","�װ���","�߰����","�⸻���","����Ʈ�����а�","test file"};
	
	public void makeParagraph_random(BufferedImage bi,  String destination ){
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		int font_size = random.nextInt(80)+15;
		int x = random.nextInt(1000);
		int y = random.nextInt(600);
		int string_list = random.nextInt(7);
		
		
		  Font font = new Font("Gungsuh", Font.BOLD, font_size);
		  


		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		  

		  File makeImage = new File(destination);

		 // File loadImage = new File(source);

		 // BufferedImage bi = null;

		  
		  


		  Graphics2D g2 = bi.createGraphics();
		  
		  g2.setColor(new Color(r,g,b));

		  g2.setFont(font);

		  
		  g2.drawString(random_text[string_list], x, y);
		  //g2.drawString(subject, 430, 503);
		  g2.dispose();

		  try {

		   ImageIO.write(bi, "jpg", makeImage);

		  } catch (IOException e) {

		   System.out.print("���ο� �̹��� ���� ���� ");

		   e.printStackTrace();

		  }



	}
	
	
	public void makeMosaic(String source , String destination){
		//1280x720
		try {
			resize(source, destination, originalWidth/10, originalHeight/10);
			resize(destination, destination , originalWidth, originalHeight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeMosaic_random(String source , String destination){
		//1280x720
		int value = random.nextInt(20)+5;
		try {
			resize(source, destination, originalWidth/value, originalHeight/value);
			resize(destination, destination , originalWidth, originalHeight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeResize(String source, String destination, int width, int height){
		try{
			this.resize(source,destination,width,height);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void makeResize_random(String source, String destination){
		try{
			this.resize_random(source,destination);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private BufferedImage resize(String source, String destination, int width, int height) throws IOException {
		
		File newFile = new File(destination);
		RenderedOp renderedOp = JAI.create("fileload", source);

		BufferedImage bufferedImage = renderedOp.getAsBufferedImage();
		BufferedImage bufferIm = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferIm.createGraphics();
		graphics2D.drawImage(bufferedImage, 0, 0, width, height, null);
		ImageIO.write(bufferIm, "jpg", newFile);
		return bufferIm;
		
	}
	
	private void resize_random(String source, String destination) throws IOException {
		int x = random.nextInt(1000)+128;
		int y = random.nextInt(600)+72;
		File newFile = new File(destination);
		RenderedOp renderedOp = JAI.create("fileload", source);

		BufferedImage bufferedImage = renderedOp.getAsBufferedImage();
		BufferedImage bufferIm = new BufferedImage(x, y,
		BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferIm.createGraphics();
		graphics2D.drawImage(bufferedImage, 0, 0, x, y, null);
		ImageIO.write(bufferIm, "jpg", newFile);
		
	}
	private BufferedImage resise(String source,int width , int height)  throws IOException{
		
		RenderedOp renderedOp = JAI.create("fileload", source);

		BufferedImage bufferedImage = renderedOp.getAsBufferedImage();
		BufferedImage bufferIm = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferIm.createGraphics();
		graphics2D.drawImage(bufferedImage, 0, 0, width, height, null);
		
		return bufferIm;
	}
	
	private BufferedImage resise_random(BufferedImage bi)  throws IOException{
		
		int x = random.nextInt(1000)+128;
		int y = random.nextInt(600)+72;
		RenderedOp renderedOp = JAI.create("fileload", bi);

		BufferedImage bufferedImage = renderedOp.getAsBufferedImage();
		BufferedImage bufferIm = new BufferedImage(x, y,
		BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferIm.createGraphics();
		graphics2D.drawImage(bufferedImage, 0, 0, x,y , null);
		
		return bufferIm;
	}
	
	private void load(){
		try{
			img = ImageIO.read(new File(filename));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void save(BufferedImage img ){
		try{
			
			ImageIO.write(img, "jpg", new File(path+"/temp/temp.png"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
