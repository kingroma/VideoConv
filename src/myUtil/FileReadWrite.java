package myUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class FileReadWrite {
	
	String txtReadPath = __Util__.fileReadPath;
	//String txtWritePath = __Util__.fileWriteMp4Path;
	File txt = null;
	
	
	public FileReadWrite() {
		txt = new File(txtReadPath);
	}
	public FileReadWrite(String txtPath) {
		this.txtReadPath= txtPath;
		txt = new File(txtPath);
	}
	
	FileOutputStream fos = null;
	
	public boolean write(String value,String path) {
		boolean return_value = true;
		txt = new File(path);
		if(txt==null) {}
			
		if(txt == null) {
			
		}else {
			if(true) {
				try {
					fos = new FileOutputStream(txt);
					fos.write(value.getBytes(Charset.forName("UTF-8")));
					
				}catch(Exception e) {
					return_value =false;
					e.printStackTrace();
				}finally {
					try {
						fos.close();
						fos = null;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return return_value;
	}
	
	FileInputStream fis = null;
	public String read() {
		String return_value = null;
		StringBuilder sb = new StringBuilder();
		txt = new File(txtReadPath);
		
		//System.out.println(txt);
		try {
			fis = new FileInputStream(txt);
			byte[] b = new byte[1];
			while(fis.read(b)!=-1) {
				sb.append(new String(b));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
					fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return_value = sb.toString();
		
		return return_value;
	}
	public String read(String path) {
		String return_value = null;
		StringBuilder sb = new StringBuilder();
		txt = new File(path);
		
		if(txt==null) {
			
		}
			
		if(!txt.exists())
			return "";
		//System.out.println(txt);
		try {
			fis = new FileInputStream(txt);
			byte[] b = new byte[1];
			while(fis.read(b)!=-1) {
				sb.append(new String(b));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
					fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return_value = sb.toString();
		
		return return_value;
	}
	
	
}
