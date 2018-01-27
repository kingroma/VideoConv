package myFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myUtil.WaitThread;

public class MyDetectStart extends JPanel{
	private static final long serialVersionUID = 2L;
	public MyDetectStart() {
		
		start();
		init();
		end();
	}
	
	JButton detectBtn = new JButton("Å½ÁöÇÏ±â");
	public static JLabel detectWaitPanel = new JLabel();
	public static String status = "stop";
	public static WaitThread thread =null;
	
	public void init() {
		this.setLayout(null);
		detectBtn.setBounds(800, 20, 150, 50);
		detectBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//do text
				if(thread==null) {
					
					thread = new WaitThread();
					thread.start();
					status = "start";
				}else {
					if(!thread.isAlive()) {
						thread = new WaitThread();
						thread.start();
						status = "start";
					}
				}
			}
			
		});
		this.add(detectBtn);
		
		detectWaitPanel.setBounds(20,20,900,50);
		this.add(detectWaitPanel);
	}
	public void start() {
		//this.setBackground(Color.orange);
	}
	
	public void end() {
		
	}
	
}
