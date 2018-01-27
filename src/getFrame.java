

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jcodec.api.FrameGrab;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Picture;

//import it.sauronsoftware.jave.*;
public class getFrame{
	String path ="C:/Users/Andrew/Desktop/skins.avi";
	String path2 = "C:/Users/Andrew/Downloads/파이트 클럽 Fight.Club.1999.720p.x264.DTS-Zoom/Fight.Club.1999.720p.x264.DTS-Zoom.mkv";
	String path3 = "C:/Users/Andrew/Downloads/[tvN] 신서유기 4.E01.170613.720p-NEXT.mp4";
	String path4 = "C:/Users/Andrew/Downloads/[tvN].mp4";
	
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	//File file = new File(path4);
	public void removeList() {
		for(int i = 0 ; i < list.size() ; i++) {
			list.remove(i);
		}
	}
	public void removeName() {
		for(int i = 0 ; i < name.size(); i++) {
			name.remove(i);
		}
	}
	public getFrame(){
		//getPicture();
		
		//getSound(path3);
	}
	
	
	/*
	public void getSound(String resource){
		
		File source = new File(path3);
        File target = new File("target.mp3");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        
        try {
            encoder.encode(source, target, attrs);
        } catch (IllegalArgumentException | EncoderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		/*
	        System.out.println(resource);
	        File source = new File(resource);
	        SeekableByteChannel input = new AutoFileChannelWrapper(source);
	        MP4Demuxer demuxer = new MP4Demuxer(input);
	        AbstractMP4DemuxerTrack track = (AbstractMP4DemuxerTrack) demuxer.getAudioTracks().get(0);
	        Packet packet;
	        while (null != (packet = track.nextFrame())) {
	            ByteBuffer data = packet.getData();
	        }
	        */
	/*
	}
	*/
	SeekableByteChannel mp4;
	FrameGrab grab;
	Picture picture;
	File file;
	public void getIntoPath(String path ,String output_path, int time, int count, double gab){
		file = new File(path);
		//String path ="C:/Users/Andrew/Desktop/skins.avi";
		//String path2 = "C:/Users/Andrew/Downloads/파이트 클럽 Fight.Club.1999.720p.x264.DTS-Zoom/Fight.Club.1999.720p.x264.DTS-Zoom.mkv";
		//String path3 = "C:/Users/Andrew/Downloads/[tvN] 신서유기 4.E01.170613.720p-NEXT.mp4";
		
		System.out.println(path+" / time : "+time+"sec  / get frame start....");
		//File file = new File(path);
		try{
			double startSec = time;
			if(mp4!=null)
				mp4.close();
			mp4 = null;
			grab = null;
			
			Picture picture = null;
			
			mp4 = NIOUtils.readableChannel(file);
			//mp4.setPosition((long)100);
			grab = FrameGrab.createFrameGrab(mp4);
			
			//grab = grab.seekToSecondPrecise(startSec);
			
		    //int frameNumber = time;
		    
		    //test
		    
		    grab = grab.seekToSecondPrecise(startSec);
		    //long curFrame = grab.getVideoTrack().getCurFrame();
		    
		    //test	
		    System.out.println("count : "+count);
			for (int i=0;i<count;i++) {
			    //picture = grab.getFrameAtSec(file,startSec+i*frame_gab+i*gab);
				
			    //test
				
				//grab.getNativeFrame();grab.getNativeFrame();grab.getNativeFrame();
				//Picture picture = grab.getNativeFrame();
				//curFrame=curFrame+temp_frame_gab;
				//grab.getVideoTrack().seek(startSec+i*frame_gab+i*gab);
				
				grab.getNativeFrame();grab.getNativeFrame();grab.getNativeFrame();
				picture = grab.getNativeFrame();//이게제일좋은듯
				
				//grab.getFrameFromChannel(file, frameNumber)
			    //test
			    //System.out.println(picture.getWidth() + "x" + picture.getHeight() + " " + picture.getColor());
			    
			    //System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
			    //System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
			    System.out.println(path+" / time : "+time+"sec  / get frame start....");
			    System.out.println("output path : "+output_path);
			    System.out.println("파일 이름 :"+"/frame_"+time+"_"+i+".jpg");
			    //System.out.println();
			    //System.out.print(""+Math.floor((i+1)*(100.0/count))+"%");
			    //System.out.println();System.out.println();
			    
			    //System.out.print(""+(i+1)*(100/count)+"%");
			    //for JDK (jcodec-javase)
			    BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
			   
			    /*
			    Graphics2D g2 = null;
			    g2 = bufferedImage.createGraphics();
			    
			    bufferedImage.getWidth();
			    bufferedImage.getHeight();
			    
			     */
			    
			    //Image imgTarget = 
			    //		bufferedImage.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);
			    //bufferedImage.getGraphics().drawImage(imgTarget, 0, 0, null);
			    //indexColorBodel
			    
			    
			    //test
			    
			    /*
			     * 용량줄이기 가능 하지만 안넣다.
			    Iterator<ImageWriter> writer = ImageIO.getImageWritersByFormatName("jpg");
			     
			    // Just get the first JPEG writer available
			    ImageWriter jpegWriter = writer.next();
			     
			    // Set the compression quality to 0.8
			    ImageWriteParam param = jpegWriter.getDefaultWriteParam();
			    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			    param.setCompressionQuality(0.6f);
			     
			    // Write the image to a file
			    FileImageOutputStream out = new FileImageOutputStream(new File(output_path+"/frame_"+time+"_"+i+".jpg"));
			    jpegWriter.setOutput(out);
			    jpegWriter.write(null, new IIOImage(bufferedImage, null, null), param);
			    jpegWriter.dispose();
			    out.close();
			    */
			    //test
			    
			    String file_new_name = "/frame_"+time+"_"+i+".jpg";
			    ImageIO.write(bufferedImage, "jpg", new File(output_path+file_new_name));
			    list.add(output_path+file_new_name);
			    name.add(file_new_name);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			grab=null;
			mp4 = null;
			picture =null;
			file = null;
		}
		/*
		System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
	    System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
		System.out.println("finish");
		System.out.println();
		*/
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath2() {
		return path2;
	}
	public void setPath2(String path2) {
		this.path2 = path2;
	}
	public String getPath3() {
		return path3;
	}
	public void setPath3(String path3) {
		this.path3 = path3;
	}
	public String getPath4() {
		return path4;
	}
	public void setPath4(String path4) {
		this.path4 = path4;
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public ArrayList<String> getName() {
		return name;
	}
	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	
}
