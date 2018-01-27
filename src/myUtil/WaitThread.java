package myUtil;

import myFrame.MyDetectStart;
import myFrame.MySelectTestFile;
import myFrame.MySelectTrainedFile;

public class WaitThread extends Thread{
	
	private boolean isRun = true;
	FileReadWrite readwrite = new FileReadWrite();
	Runtime rt = null;
	String path = "";
	//Process p = null;
	//String exeFile = __Util__.exeFile;
	//rt = Runtime.getRuntime();
	//p = rt.exec(exeFile);
	public WaitThread() {
		
	}
	
	public boolean passMyValue() {
		
		String mp4Path = MySelectTestFile.path_text.getText();
		System.out.println("mp4 : "+mp4Path);
		String trainedPath = MySelectTrainedFile.textFile.getText();
		System.out.println("trained : "+trainedPath);
		
		if(mp4Path==null)
			return false;
		if(mp4Path.equals(""))
			return false;
		if(trainedPath==null)
			return false;
		if(trainedPath.equals(""))
			return false;
		//path = MySelectTestFile.path_text.getText();
		
		
		readwrite.write(mp4Path, __Util__.fileWriteMp4Path);
		readwrite.write(trainedPath, __Util__.fileWriteTrainedPath);
		readwrite.write("", __Util__.fileReadPath);
		
		//readwrite.write(value, path)
		return true;
	}
	int count = 0;
	String text = "Ž���� ";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread ����");
		text = "Ž���� ";
		if(passMyValue()) {
			while(isRun) {
				try {
					this.sleep(500);
					if(count == 50) {
						count = 0;
						text = "Ž���� ";
					}
					count++;
					text+="�� ";
					
					MyDetectStart.detectWaitPanel.setText(text);
					
					if(readwrite.read()!=null) {
						String read_text = readwrite.read(__Util__.fileReadPath);
						//System.out.println("read text : "+read_text);
						if(!read_text.equals("")&read_text.length()>5){
							isRun=false;
							MyDetectStart.detectWaitPanel.setText(read_text);
						}
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				//System.out.println("����");
			}
		}else {
			MyDetectStart.detectWaitPanel.setText("����(or Ʈ����) �� �̻����ֽ��ϴ� Ȯ�����ּ���");
		}
		System.out.println("thread ��");
	}
	
	public void setRun(boolean isRun) {
		this.isRun = isRun;
		
	}

	public void end() {
		isRun=false;
		
		
	}
}
