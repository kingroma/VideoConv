package myFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import myUtil.__Util__;

public class MyFrame extends JFrame{
	private static final long serialVersionUID = 1L;
//	�⺻ ���� ������ 9�� ���� ���� . 
	
	/**
	 * 
	 */
	
	private int width = 1800;
	private int height = 1000;
	Font basicFont = new Font("����", Font.BOLD, 23);
	public MyFrame() {
		start();
		
		setMyTuhmnalNormal();
		setMyThumbnailAbNormal();
		setMySelectTestFile();
		setMySelectTrainedFile();
		setMyDetectStart();
		
		work();
		end();
	}
	//���� ���� Path ���� 
	String normalVideoPath = __Util__.normalVideoPath;
	MyThumbnailNormal myThumbnailNormal = null;
	JLabel thumbnailNormalText = null;
	TitledBorder showVideoBorder = new TitledBorder(new LineBorder(Color.black),"");
	TitledBorder showWhiteBorder = new TitledBorder(new LineBorder(Color.white),"");
	public void setMyTuhmnalNormal() {
		myThumbnailNormal = new MyThumbnailNormal(normalVideoPath);
		this.add(myThumbnailNormal);
		myThumbnailNormal.setBounds(new Rectangle(1040,40,720,420));
		myThumbnailNormal.setBorder(showVideoBorder);
		
		thumbnailNormalText = new JLabel("���� ������ ����");
		thumbnailNormalText.setFont(basicFont);
		thumbnailNormalText.setBounds(1040,10,730,30);
		this.add(thumbnailNormalText);
		//myThumbnailNormal.init();
	}
	
	//������ ���� Path ����
	public static String abnormalVideoPath = __Util__.abnormalVideoPath;
	public static MyThumbnailAbNormal myThumbnailAbNormal = null;
	private JLabel thumbnailAbNormalText = null;
	//private JButton abUp = new JButton("��");
	//private JButton abDown = new JButton("��");
	public void setMyThumbnailAbNormal() {
		myThumbnailAbNormal = new MyThumbnailAbNormal(abnormalVideoPath);
		/*
		abUp.setBounds(1000, 510, 45, 45);
		abUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myThumbnailAbNormal.up();
			}
		});
		this.add(abUp);
		abDown.setBounds(1000, 870, 45, 45);
		abDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myThumbnailAbNormal.down();
			}
		});
		this.add(abDown);
		*/
		this.add(myThumbnailAbNormal);
		myThumbnailAbNormal.setBounds(new Rectangle(1040,505,720,420));
		myThumbnailAbNormal.setBorder(showVideoBorder);
		
		thumbnailAbNormalText = new JLabel("�ҹ� ���� ���� ����");
		thumbnailAbNormalText.setFont(basicFont);
		thumbnailAbNormalText.setBounds(1040,475,730,30);
		this.add(thumbnailAbNormalText);
		
		
	}
	
	MySelectTestFile mySelectTestFile = null;
	public void setMySelectTestFile() {
		mySelectTestFile = new MySelectTestFile();
		this.add(mySelectTestFile);
		mySelectTestFile.setBounds(new Rectangle(10,10,1000,200));
		mySelectTestFile.setBorder(showWhiteBorder);
	}
	
	public static MySelectTrainedFile mySelectTrainedFile = null;
	public void setMySelectTrainedFile() {
		mySelectTrainedFile = new MySelectTrainedFile();
		this.add(mySelectTrainedFile);
		mySelectTrainedFile.setBounds(new Rectangle(10,230,1000,450));
		mySelectTrainedFile.setBorder(showWhiteBorder);
	}
	
	MyDetectStart myDetectStart = null;
	public void setMyDetectStart() {
		myDetectStart = new MyDetectStart();
		this.add(myDetectStart);
		myDetectStart.setBounds(new Rectangle(10,700,1000,230));
		myDetectStart.setBorder(showWhiteBorder);
	}
	
	public void work() {
		myThumbnailNormal.work();
		//myThumbnailAbNormal.work();
	}
	public void start() {
		this.setLayout(null);
		this.setTitle("ML �ҹ����� Ž��");
		this.setBounds(0,0,width,height);
		
		ImageIcon img = new ImageIcon("kau.jpg");
		this.setIconImage(img.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void end() {
		//this.pack();
	}
}
