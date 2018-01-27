package myFrame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jcodec.api.FrameGrab;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Picture;

import myUtil.AWTUtil;

public class MyThumbnailAbNormal  extends JPanel{
	private static final long serialVersionUID = 5L;
	
	
	private JFrame frame = null;
	private File[] fileList = null;
	private String[] fileNameList = null;
	private ArrayList<String> mp4PathList = null;
	private String path = "";
	public void setPath(String path) {
		this.path = path ;
	}
	public MyThumbnailAbNormal(String abnormalFileFolder) {
		start();
		this.path = abnormalFileFolder;
		frame = (JFrame)this.getParent();
		end();
	}
	public void work(String keyword) {
		System.out.println("abnormal work");
		getFileList(keyword);
		setImage();
	}
	
	public void start() {
		//this.setBackground(Color.blue);
		this.setLayout(null);
	}
	
	public void getFileList(String keyword) {
		System.out.println("keyword : "+keyword);
		mp4PathList = new ArrayList<String>();
		this.removeAll();
		if(path !=null) {
			if(!path.equals("")) {
				File file_temp = new File(path);
				fileNameList = file_temp.list();
				
				for(int i = 0 ; i < fileNameList.length ; i ++) {
					//System.out.println(fileNameList[i]);
					int dotIndex = fileNameList[i].lastIndexOf('.');
					String type = fileNameList[i].substring(dotIndex + 1);
					if(type !=null) {
						if(type.equals("mp4")) {
							if(mp4PathList==null)
								mp4PathList = new ArrayList<String>();
							if(fileNameList[i].contains(keyword)) {
								System.out.println("add : "+path+"\\"+fileNameList[i]);
								mp4PathList.add(path+"\\"+fileNameList[i]);
							}
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
	ArrayList<JLabel> label_file_list = new ArrayList<JLabel>();
	ArrayList<JButton> btnList = new ArrayList<JButton>();
	public void setImage() {
		int btn_width = (int)(128*1.6);
		int btn_height = (int)(72*1.6);
		int margin = 5;
		int btn_x_gap = 0;
		int btn_y_gap = 0;
		
		int text_margin_y = btn_height+3;
		//
		
		ArrayList<JLabel> label_file_list = new ArrayList<JLabel>();
		ArrayList<JButton> btnList = new ArrayList<JButton>();
		
		if(mp4PathList!=null) {
			try {
				for(int i = 0 ; i < mp4PathList.size() ; i++) {
					if(i==9)
						break;
					if(i %3 == 0) {
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
					Image img = Toolkit.getDefaultToolkit().createImage(bi.getSource());
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
					
					
					
					btn_temp.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							MySelectTestFile.path_text.setText(btn_temp.getName());
							MySelectTestFile.theSelectPictrue.setIcon(btn_temp.getIcon());
						}
						
					});
					
					this.add(btn_temp);
					this.add(btn_text_temp);
					btnList.add(btn_temp);	
					label_file_list.add(btn_text_temp);
					
					btn_x_gap+=240;
					
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
	
	public void addMouseFunction() {
		
	}
	
	public void end() {
		
	}
	
	int scale = 10;
	int current_y = 0;
	public void up() {
		System.out.println("up");
		if(current_y!=0) {
			current_y+=10;
			int x = 0 ;
			int y = 0 ;
			int width = 0;
			int height = 0;
			Icon img = null;
			for(int i = 0 ; i < btnList.size() ; i++ ) {
				x = label_file_list.get(i).getBounds().x;				
				y = label_file_list.get(i).getBounds().y+scale;
				width = label_file_list.get(i).getBounds().width;
				height = label_file_list.get(i).getBounds().height;
				
				label_file_list.get(i).setBounds(x,y,width,height);
				img = btnList.get(i).getIcon();
				x = btnList.get(i).getBounds().x;				
				y = btnList.get(i).getBounds().y+scale;
				width = btnList.get(i).getBounds().width;
				height = btnList.get(i).getBounds().height;
				
				btnList.get(i).setBounds(x,y,width,height);
				btnList.get(i).setIcon(img);
				//this.add(btnList.get(i));
				//btnList.get(i).setIcon(btnList.get(i).getIcon());
				
				
				
			}
		}
		//repaint();
		//validate();
	}
	public void down() {
		System.out.println("down");
		int max_y = (int)(btnList.size()/3*200);
		if(current_y<max_y) {
			current_y-=10;
			int x = 0 ;
			int y = 0 ;
			int width = 0;
			int height = 0;
			Icon img = null;
			for(int i = 0 ; i < btnList.size() ; i++ ) {
				x = label_file_list.get(i).getBounds().x;				
				y = label_file_list.get(i).getBounds().y-scale;
				width = label_file_list.get(i).getBounds().width;
				height = label_file_list.get(i).getBounds().height;
				
				label_file_list.get(i).setBounds(x,y,width,height);
				
				img = btnList.get(i).getIcon();
				x = btnList.get(i).getBounds().x;				
				y = btnList.get(i).getBounds().x-scale;
				width = btnList.get(i).getBounds().width;
				height = btnList.get(i).getBounds().height;
				
				btnList.get(i).setBounds(x,y,width,height);
				//this.add(btnList.get(i));
				//btnList.get(i).setIcon(btnList.get(i).getIcon());
				btnList.get(i).setIcon(img);
				
				
			}
		}
		//repaint();
		//validate();
		//frame.repaint();
		//frame.validate();
	}
	
	
	
	
}
