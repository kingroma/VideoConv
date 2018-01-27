package myFrame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jcodec.api.FrameGrab;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Picture;

import myUtil.AWTUtil;

public class MyThumbnailNormal  extends JPanel{
	private static final long serialVersionUID = 6L;
	File[] fileList = null;
	String[] fileNameList = null;
	ArrayList<String> mp4PathList = null;
	String path = "";
	public void setPath(String path) {
		this.path = path ;
	}
	public MyThumbnailNormal(String normalFileFolder) {
		start();
		this.path = normalFileFolder;
		
		end();
	}
	public void work() {
		
		getFileList();
		
		setImage();
		
		//addMouseFunction();
	}
	
	public void start() {
		//this.setBackground(Color.red);
		this.setLayout(null);
	}
	
	public void getFileList() {
		if(path !=null) {
			if(!path.equals("")) {
				File file_temp = new File(path);
				fileNameList = file_temp.list();
				
				for(int i = 0 ; i < fileNameList.length ; i ++) {
					int dotIndex = fileNameList[i].lastIndexOf('.');
					String type = fileNameList[i].substring(dotIndex + 1);
					if(type !=null) {
						if(type.equals("mp4")) {
							if(mp4PathList==null)
								mp4PathList = new ArrayList<String>();
							mp4PathList.add(path+"\\"+fileNameList[i]);
						}
					}
				}
			}
		}
	}
	public void MP4Extract() {
		
	}
	
	SeekableByteChannel mp4 = null;
	FrameGrab grab = null;
	Picture picture = null;
	ArrayList<JLabel> label_file_list = null;
	
	ArrayList<JButton> btnList = new ArrayList<JButton>();
	Image img;
	public void setImage() {
		int btn_width = (int)(128*1.2);
		int btn_height = (int)(72*1.2);
		int margin = 5;
		int btn_x_gap = 0;
		int btn_y_gap = 0;
		
		int text_margin_y = btn_height+3;
		
		if(mp4PathList!=null) {
			try {
				for(int i = 0 ; i < mp4PathList.size() ; i++) {
					if(i==10)
						break;
					if(i %4 == 0) {
						if(i!=0) {
							btn_x_gap = 0;
							btn_y_gap += 138;
						}
					}
					if(mp4!=null)
						mp4.close();
						
					mp4 = null;
					grab = null;
					
					System.out.println(mp4PathList.get(i));
					File mp4File = new File(mp4PathList.get(i));
					
					mp4 = NIOUtils.readableChannel(mp4File);
					grab = FrameGrab.createFrameGrab(mp4);
					int frame_start = grab.getVideoTrack().getMeta().getTotalFrames()/4;
					
					grab = grab.seekToFramePrecise(frame_start);
					picture = grab.getNativeFrame();
					BufferedImage bi = AWTUtil.toBufferedImage(picture);
					img = Toolkit.getDefaultToolkit().createImage(bi.getSource());
					img = img.getScaledInstance(btn_width, btn_height, Image.SCALE_SMOOTH);
					
					JButton btn_temp = new JButton("");
					btn_temp.setBounds(btn_x_gap+margin, btn_y_gap+margin, btn_width, btn_height);
					
					btn_temp.setIcon(new ImageIcon(img));
					
					System.out.println("read finish");
					//Image image = ImageIO.read(new File("C:\\Users\\Andrew\\Desktop\\frame\\myFrame\\Design.png"));
					//btn_temp.setIcon(new ImageIcon(image.getScaledInstance(btn_width, btn_height, Image.SCALE_DEFAULT)));
					JLabel btn_text_temp = new JLabel(mp4File.getName());
					btn_text_temp.setHorizontalAlignment(SwingConstants.CENTER);
					btn_text_temp.setBounds(btn_x_gap+margin, btn_y_gap+margin+text_margin_y, btn_width, 20);
					btn_temp.setName(mp4PathList.get(i));
					this.add(btn_temp);
					this.add(btn_text_temp);
					btn_temp.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							MySelectTestFile.path_text.setText(btn_temp.getName());
							MySelectTestFile.theSelectPictrue.setIcon(btn_temp.getIcon());
							
							//MyFrame.myThumbnailAbNormal.setPath(btn_temp.getName());
							MyFrame.myThumbnailAbNormal.work(mp4File.getName().substring(0, mp4File.getName().length()-5));
							MyFrame.mySelectTrainedFile.work(mp4File.getName().substring(0, (int)(mp4File.getName().length()/2)));
							
						}
					});
					
					btnList.add(btn_temp);	
					
					btn_x_gap+=180;
					
				}
				
				
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		JButton btn_temp = new JButton("");
		btn_temp.setBounds(0, 0, btn_width, btn_height);
		
		
		
		
		repaint();
		validate();
		/*
		try {
			Image image = ImageIO.read(new File("C:\\Users\\Andrew\\Desktop\\frame\\myFrame\\Design.png"));
			btn_temp.setIcon(new ImageIcon(image.getScaledInstance(btn_width, btn_height, Image.SCALE_DEFAULT)));
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	int count = 0;
	public void addMouseFunction() {
		System.out.println(btnList.size());
		if(btnList!=null) {
			System.out.println(count);
			for(count = 0 ; count < btnList.size() ; count ++) {				
				//System.out.println(count);
				btnList.get(count).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						MySelectTestFile.path_text.setText(btnList.get(count).getName());
						MySelectTestFile.theSelectPictrue.setIcon(btnList.get(count).getIcon());
					}
					
				});
				
			}
		}
	}
	
	public void end() {
		
	}
	
	
	
	
}
