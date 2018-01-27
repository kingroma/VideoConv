package myFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import myUtil.FileReadWrite;
import myUtil.__Util__;

public class MySelectTrainedFile  extends JPanel{
	private static final long serialVersionUID = 4L;
	Font basicFont = new Font("바탕", Font.BOLD, 23);
	JFrame frame = null;
	public MySelectTrainedFile() {
		
		start();
		init();
		end();
	}
	
	JLabel textMain = new JLabel("trained 파일 선택"); 
	public static JLabel textFile = new JLabel("");
	public JTextArea dataFile = new JTextArea();
	JButton selectTrainedData = new JButton("파일선택");
	String path = __Util__.fileTrainedDataPath;
	
	public void work(String keyword) {
		File file = new File(path);
		String[] file_name_list = file.list();
		
		for(int i = 0 ; i < file_name_list.length ; i ++) {
			if(file_name_list[i].contains(keyword)) {
				System.out.println("path : "+path+"\\"+file_name_list[i]);
				String the_path = path+"\\"+file_name_list[i];
				textFile.setText(the_path);
				FileReadWrite read = new FileReadWrite();
				String read_data_string_temp =read.read(the_path);
				String read_data_string = "";
				int count = 0;
				for(int  j = 0 ; j < read_data_string_temp.length() ; j ++) {
					String string_temp =read_data_string_temp.substring(j, j+1); 
					
					read_data_string+=string_temp;
					
					if(string_temp.equals(" ")) {
						count++;
						if(count == 5) {
							count = 0;
							read_data_string+="\n";
						}
					}
				}
				dataFile.setText(read_data_string);
				break;
				
			}
		}
	}
	public void init() {
		textMain.setFont(basicFont);
		textMain.setBounds(10,10,700,50);
		this.add(textMain);
		
		textFile.setBounds(10,70,800,30);
		this.add(textFile);
		
		dataFile.setBounds(30,110,880,400);
		dataFile.setEditable(false);
		dataFile.setBackground(Color.white);
		this.add(dataFile);
		
		selectTrainedData.setBounds(870,10,100,30);
		selectTrainedData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				//fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showDialog(frame , null);
				
				if(fileChooser.getSelectedFile()!=null) {
					String selectPath = fileChooser.getSelectedFile().toString();
					textFile.setText(selectPath);
					
					int dotIndex = selectPath.lastIndexOf('.');
					String type = selectPath.substring(dotIndex + 1);
					if(type !=null) {
						if(type.equals("txt")) {
							try {
								FileReadWrite read = new FileReadWrite();
								String read_data_string_temp =read.read(selectPath);
								String read_data_string = "";
								int count = 0;
								for(int  j = 0 ; j < read_data_string_temp.length() ; j ++) {
									String string_temp =read_data_string_temp.substring(j, j+1); 
									
									read_data_string+=string_temp;
									
									if(string_temp.equals(" ")) {
										count++;
										if(count == 5) {
											count = 0;
											read_data_string+="\n";
										}
									}
								}
								dataFile.setText(read_data_string);
								
								//and do something
								
							}catch(Exception exception) {
								exception.printStackTrace();
							}
						}
					}
				}
				
			}
			
		});
		this.add(selectTrainedData);
	}
	public void start() {
		this.setLayout(null);
		//setBackground(Color.gray);
		frame = (JFrame)this.getParent();
	}
	
	
	public void end() {
		
	}
}
