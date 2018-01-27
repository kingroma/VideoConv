package myFrame;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jcodec.api.FrameGrab;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Picture;

import myUtil.AWTUtil;

public class MySelectTestFile  extends JPanel{
	private static final long serialVersionUID = 3L;
	private Font basicFont = new Font("바탕", Font.BOLD, 23);
	private JFrame frame = (JFrame) this.getParent();
	public MySelectTestFile() {
		start();
		init();
		addListener();
		end();
	}
	
	public void start() {
		//this.setBackground(Color.green);
		this.setLayout(null);
	}
	private JLabel init_text = new JLabel("테스트 비디오 선택");
	public static JLabel path_text = new JLabel("");
	public static JLabel theSelectPictrue = new JLabel();
	private JButton selectBtn = new JButton("파일 선택");
	
	public void init() {
		//테스트 비디오 선택
		
		init_text.setBounds(10,10,500,30);
		init_text.setFont(basicFont);
		this.add(init_text);
		
		selectBtn.setBounds(870,10,100,30);
		this.add(selectBtn);
		
		path_text.setBounds(30,50,700,30);
		this.add(path_text);
		
		theSelectPictrue.setBounds(720, 50, 128*2, 72*2);
		this.add(theSelectPictrue);
	}
	
	private SeekableByteChannel mp4 = null;
	private FrameGrab grab = null;
	private Picture picture = null;
	
	public void addListener() {
		selectBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				//fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showDialog(frame , null);
				
				if(path_text!= null) {
					if(!path_text.equals("")) {
						if(fileChooser.getSelectedFile()!=null) {
							
							String selectPath = fileChooser.getSelectedFile().toString();
						
							path_text.setText(selectPath);
							
							int dotIndex = selectPath.lastIndexOf('.');
							String type = selectPath.substring(dotIndex + 1);
							if(type !=null) {
								if(type.equals("mp4")) {
									try {
										System.out.println("frame start");
										if(mp4!=null)
											mp4.close();
											
										mp4 = null;
										grab = null;
										
										//System.out.println(mp4PathList.get(i));
										File mp4File = new File(selectPath);
										
										mp4 = NIOUtils.readableChannel(mp4File);
										grab = FrameGrab.createFrameGrab(mp4);
										int frame_start = grab.getVideoTrack().getMeta().getTotalFrames()/4;
										
										grab = grab.seekToFramePrecise(frame_start);
										picture = grab.getNativeFrame();
										BufferedImage bi = AWTUtil.toBufferedImage(picture);
										Image img = Toolkit.getDefaultToolkit().createImage(bi.getSource());
										System.out.println("frame finish");
										theSelectPictrue.setIcon(new ImageIcon(img));
										
									}catch(Exception exception) {
										exception.printStackTrace();
									}
								}
							}
						}
					}
				}
				
			}
			
		});
	}
	
	public void end() {
		
	}

	
	
	
	
	/*
	
	*/
}
