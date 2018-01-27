

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import javax.imageio.ImageIO;


//getMedia get = new getMedia();


//100프레임만 
//동영상을 size 작게 해서 해보기 
//글자 넣고 / 모자이크나 뒷 배경을 넣다던가 / 변환 사진을 넣거나  / 사이즈 적게하기 
//셈플 뽑기 rgb 변환  프레임만 변환하면 됨 .3000개정도  / 댓글 변분에 
// youtube api 들여다 보기 

//다한거 글자넣는것 / 모자이크하는것 / 사이즈 적게가능 / 밝기 / 소금 후추 

public class main {
	public static getExcel excel = new getExcel();
	public static getFrame video = new getFrame();

	public static final String mp4_path = "C:/Users/Andrew/Downloads/[tvN].mp4";
	public static final String xlsx_path = "C:/Users/Andrew/Desktop/하이라이트.xlsx";
	public static final String output_path ="C:/Users/Andrew/Desktop/output"; 
	
	public static long startTime;
	public static long currentTime;
	
	public static BufferedImage background_img = null; 
	
	public static ArrayList<Integer> time = new ArrayList<Integer>();
	public static ArrayList<Integer> time2 = new ArrayList<Integer>();
	
	// img to mp4
	public static void main(String[] args){
		String outputPath="C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\effect\\";
		imgToMp4 test = new imgToMp4();
		String bubblePath = "C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\bubble\\";
		String analogPath = "C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\analog\\";
		String salt_pepperPath = "C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\salt_pepper\\";
		String checkLinePath = "C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\checkLine\\";
		
		// mp4 -> jpg
		File mp4File = new File("C:\\Users\\Andrew\\Desktop\\output\\뮤비\\뮤비\\변형\\아이유.mp4");
		test.Mp4ToImg(mp4File, outputPath);
		// mp4 -> jpg
		
		
		
		
		//init
		File init_file = new File(outputPath);
		File[] init_files = init_file.listFiles();
		
		//sort
		Arrays.sort(init_files, new Comparator<File>(){
		    public int compare(File f1, File f2)
		    {
		        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
		    } 
		});
		//init
		
		//jpg -> bubble.jpg 잘됨
		/*
		for(int i = 0 ; i < init_files.length ; i++){
			test.effectBubble(
					init_files[i].getAbsolutePath(), 
					bubblePath+i+".jpg");
		}		
		*/
		//jpg -> bubble.jpg 
		
		
		// jpg -> mp4 ok  bubble
		//File file = new File(bubblePath);
		//test.doChange(file, "test.mp4");
		// jpg -> mp4 bubble 42초가 되어야함 
		
		
		//jpg -> alanlog
		/*
		for(int i = 0 ; i < init_files.length ; i++){
			test.analog(
					init_files[i].getAbsolutePath(), 
					analogPath+i+".jpg");
		}
		*/
		// jpg -> analog
		
		
		// jpg -> mp4 ok  analog
		//File file = new File(analogPath);
		//test.doChange(file, "test.mp4");
		//jpg -> mp4 analog 42초가 되어야함 
		
		
		// jpg -> salt_pepper
		/*
		for(int i = 0 ; i < init_files.length ; i++){
			test.salt_and_pepper(
					init_files[i].getAbsolutePath(), 
					salt_pepperPath+i+".jpg");
		}
		*/
		// jpg -> salt_pepper
		
		// salt->mp4
		//File file = new File(analogPath);
		//test.doChange(file, "salt.mp4");
		// salt->mp4
		
		
		// jpg -> checkLine
		/*
		for(int i = 0 ; i < init_files.length ; i++){
			test.checkLine(
					init_files[i].getAbsolutePath(), 
					checkLinePath+i+".jpg");
		}
		*/
		// jpg -> checkLine
				
		// checkLine->mp4
		
		//File file = new File(checkLinePath);
		//test.doChange(file, "checkLine.mp4");
		
		// checkLine->mp4
		
		
		
		// jpg -> salt_pepper + bubble
		//salt
		for(int i = 0 ; i < init_files.length ; i++){
			test.salt_and_pepper(
					init_files[i].getAbsolutePath(), 
					salt_pepperPath+i+".jpg");
		}
		
		//buble
		for(int i = 0 ; i < init_files.length ; i++){
			test.effectBubble(
					salt_pepperPath, 
					bubblePath+i+".jpg");
		}	
		// make mp4
		File file = new File(bubblePath);
		test.doChange(file, "bubble_salt.mp4");
		// jpg -> salt_pepper + bubble
		
	}
	
	/* 이거 그냥 변형 
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//effectImg e = new effectImg();
		
		String mv_name1 ="멜로망스 - 선물"; // o
		String mv_name2 = "뉴이스트 - HELLO";
		String mv_name3 = "레드벨벳 - 빨간 맛";
		String mv_name4 = "볼빨간사춘기 - 나만 안되는 연애";
		String mv_name5 = "볼빨간사춘기 - 썸 탈꺼야";
		String mv_name6 = "아이유 - 잠 못 드는 밤 비는 내리고";
		String mv_name7 = "엑소 - Ko Ko Bop";
		String mv_name8 = "지코 - Artist";
		String mv_name9 = "헤이즈 - 널 너무 모르고";
		String mv_name10 = "헤이즈 - 비도 오고 그래서";
		
		//time.add(10);
				time.add(60);
				//time.add(90);
				time.add(160);
				//time.add(170);
				//time.add(200);
				time.add(210);
				
				//time.add(10);
				time2.add(60);
				//time.add(90);
				time2.add(100);
				//time.add(170);
				//time.add(200);
				time2.add(160);

		File loadBackgroundImage = new File("C:/Users/Andrew/Desktop/output/temp/backgroundImg.jpg");
		try{
			background_img = ImageIO.read(loadBackgroundImage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//썸탈거야 3
		//널너무 모르고 3
		
		//doChange(mv_name1);
		//doChange(mv_name2);
		//doChange(mv_name3);
		
		doChange(mv_name4);
		doChange2(mv_name5);
		doChange(mv_name6);
		doChange(mv_name7);
		doChange(mv_name8);
		doChange2(mv_name9);
		doChange(mv_name10);
		
	}
	*/
	// 5 / 9
	 
	public static void doChange(String mv_name) {
		
		//BufferedImage background_img = null;
		
		//getImg_effectImg(mp4_path, output_path,75,0);
		//getImg_OnlyOne(mp4_path, output_path,500,0);
		//getEffectByImg("",output_path,300,0);
		
		//숏터뷰 
		
		
		//time.add(250);
		//time.add(290);
		
		
		//String short_path = "C:/Users/Andrew/Desktop/output/short/양세형의 숏터뷰 - 이상민.mp4";
		String short_output_path = "C:\\Users\\Andrew\\Desktop\\output\\short\\output";
		
		String file_type=".mp4";
		
		
		
		String mv_path= "C:\\Users\\Andrew\\Desktop\\output\\뮤비\\"+mv_name+file_type;
		String mv_output_path = mv_path+"/output";
		
		File temp = new File(mv_output_path);
		if(!temp.exists()) {
			temp.mkdirs();
		}
		
		
		video.removeList();
		video.removeName();
		
		
		System.out.println("time size :"+time.size());
		for(int i = 0 ; i < time.size() ; i ++) {
			video.getIntoPath(mv_path, short_output_path, time.get(i), 1, 0);
		}
		
		
		startTime = System.currentTimeMillis();
		//위치 , 이름 , 몇개진행 ? , temp
		
		
		ArrayList<String> outList = video.getList();
		ArrayList<String> outName = video.getName();
		for(int i = 0 ; i < outList.size()-1 ; i ++) {
			for(int j = i+1 ; j < outList.size() ; j++) {
				if(outList.get(i).equals(outList.get(j))){
					outList.remove(i);
				}
			}
		}
		
		for(int i = 0 ; i < outName.size()-1 ; i ++) {
			for(int j = i+1 ; j < outName.size() ; j++) {
				if(outName.get(i).equals(outName.get(j))){
					outName.remove(i);
				}
			}
		}
		System.out.println(outList.size());
		System.out.println(outName.size());
		getEffectByImg(outList,outName,400,0,mv_name);//최신	
		
		
		//getEffectUpgradeByImg("",output_path,300,0);
		/*
			//사운드 추출
			InputStream is = new FileInputStream(file);
			AudioStream audioStream = new AudioStream(is);
		*/
		 long stopTime = System.currentTimeMillis();
		 long runTime = stopTime - startTime;
	 
		 
		 //background이미지 생각 
		 
		 System.out.println(runTime/1000+"초");

	}

	public static void doChange2(String mv_name) {
	
	//BufferedImage background_img = null;
	
	//getImg_effectImg(mp4_path, output_path,75,0);
	//getImg_OnlyOne(mp4_path, output_path,500,0);
	//getEffectByImg("",output_path,300,0);
	
	//숏터뷰 
	
	
	//time.add(250);
	//time.add(290);
	
	
	//String short_path = "C:/Users/Andrew/Desktop/output/short/양세형의 숏터뷰 - 이상민.mp4";
	String short_output_path = "C:\\Users\\Andrew\\Desktop\\output\\short\\output";
	
	String file_type=".mp4";
	
	
	
	String mv_path= "C:\\Users\\Andrew\\Desktop\\output\\뮤비\\"+mv_name+file_type;
	String mv_output_path = mv_path+"/output";
	
	File temp = new File(mv_output_path);
	if(!temp.exists()) {
		temp.mkdirs();
	}
	
	
	video.removeList();
	video.removeName();
	
	
	System.out.println("time size :"+time2.size());
	for(int i = 0 ; i < time2.size() ; i ++) {
		video.getIntoPath(mv_path, short_output_path, time2.get(i), 1, 0);
	}
	
	
	startTime = System.currentTimeMillis();
	//위치 , 이름 , 몇개진행 ? , temp
	
	
	ArrayList<String> outList = video.getList();
	ArrayList<String> outName = video.getName();
	for(int i = 0 ; i < outList.size()-1 ; i ++) {
		for(int j = i+1 ; j < outList.size() ; j++) {
			if(outList.get(i).equals(outList.get(j))){
				outList.remove(i);
			}
		}
	}
	
	for(int i = 0 ; i < outName.size()-1 ; i ++) {
		for(int j = i+1 ; j < outName.size() ; j++) {
			if(outName.get(i).equals(outName.get(j))){
				outName.remove(i);
			}
		}
	}
	System.out.println(outList.size());
	System.out.println(outName.size());
	getEffectByImg(outList,outName,400,0,mv_name);//최신	
	
	
	//getEffectUpgradeByImg("",output_path,300,0);
	/*
		//사운드 추출
		InputStream is = new FileInputStream(file);
		AudioStream audioStream = new AudioStream(is);
	*/
	 long stopTime = System.currentTimeMillis();
	 long runTime = stopTime - startTime;
 
	 
	 //background이미지 생각 
	 
	 System.out.println(runTime/1000+"초");

}

	public static String img_path = "C:/Users/Andrew/Desktop/output/frame_600_0.jpg";
	public static void effectupgrade_all_random(int i ,BufferedImage bi , String destination){
		
		
		effectImgUpgrade e = new effectImgUpgrade();
		
		e.makeMosaic_random(img_path, destination+"_mosaic_"+i+".jpg");
		
		e.makeParagraph_random(bi, destination+"_paragraph_"+i+".jpg");
		
		e.light_black_random(bi, destination+"_black_"+i+".jpg");
		
		e.light_white_random(bi, destination+"_white_"+i+".jpg");
		
		e.salt_and_pepper_random(bi, destination+"_salt_and_pepper_"+i+".jpg");
		
		e.setBackground_random(img_path, destination+"_background_"+i+".jpg", background_img);
		
		e.setDrawImgCircle(img_path, destination+"_circle_background_"+i+".jpg", background_img);
		
		//e.setCheck(source, destination+"_check_"+i+".jpg");
		
		e.setCheckLine(bi, destination+"_check_line_s"+i+".jpg");
		
		e.analog(bi, destination+"_analog_"+i+".jpg");
		
		e.bubble(bi, destination+"_bubble_"+i+".jpg");
		
		e.dig(bi, destination+"_dig_"+i+".jpg");
		//System.out.println("완료");
	}
	
	public static void getEffectUpgradeByImg(String my_input_path, String my_output_path, int count , int gab){
		
		String img_name = "frame_600_0.jpg";
		
		System.out.println("이펙트 부분 추출 ");
		System.out.println("start");
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		list.add(img_path);
		name.add(img_name);
		
		String source = list.get(0);
		String destination = output_path+"/effect/";
		
		
		
		for(int i = 0 ; i <  count; i ++){
			
			File loadImage = new File(source);
			BufferedImage bi = null;
			
			
			try{
				bi = ImageIO.read(loadImage);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			System.out.println(i+" # effect start....");
			effectupgrade_all_random(i,bi,destination+"/"+name.get(0));
			//System.out.println(source+" # end....");
			
			
		}
		currentTime = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(currentTime-startTime)/1000+"초");
		System.out.println("finish");
	}
	
	public static effectImg e = new effectImg();
	//마지막 effect
	public static void getEffectByImg(ArrayList<String> list , ArrayList<String> name,  int count , int gab,String fileName){
		
		//ArrayList<String> list = new ArrayList<String>();
		//ArrayList<String> name = new ArrayList<String>();
		/*
		String img_path1 = "C:/Users/Andrew/Desktop/output/trans1.jpg";
		String img_name1 = "trans1";
		
		String img_path2 = "C:/Users/Andrew/Desktop/output/trans2.jpg";
		String img_name2 = "trans2";
		
		String img_path3 = "C:/Users/Andrew/Desktop/output/trans3.jpg";
		String img_name3 = "trans3";
		
		String img_path4 = "C:/Users/Andrew/Desktop/output/trans4.jpg";
		String img_name4 = "trans4";

		String img_path5 = "C:/Users/Andrew/Desktop/output/trans5.jpg";
		String img_name5 = "trans5";
		
		
		System.out.println("이펙트 부분 추출 ");
		System.out.println("start");
		
		
		list.add(img_path1);
		name.add(img_name1);
		list.add(img_path2);
		name.add(img_name2);
		list.add(img_path3);
		name.add(img_name3);
		list.add(img_path4);
		name.add(img_name4);
		list.add(img_path5);
		name.add(img_name5);
		*/
		
		String source = list.get(0);
		String destination = output_path+"/effect/"+fileName;
		
		for(int z = 0 ; z < list.size() ; z ++){
			source = list.get(z);
			//String new_destination = destination+"/"+name.get(z);
			File new_file = new File(destination);
			if(!new_file.exists())
				new_file.mkdirs();
			
			
			
			
			
			try {
			e.setBi(ImageIO.read(new File(source)));
			e.setRaster(ImageIO.read(new File(source)).getRaster());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//
			for(int i = 0 ; i <  count; i ++){
				
				
				new_file = new File(destination+"/"+(z+1)+"/");
				if(!new_file.exists())
					new_file.mkdirs();
				
				//System.out.println("z: "+z+" / "+i+" # effect start....");
				effect_all_random(i,source,destination+"/"+(z+1)+"/"+name.get(z));
				//System.out.println(source+" # end....");
				
				
			}
			currentTime = System.currentTimeMillis();
			System.out.println("걸린시간 : "+(currentTime-startTime)/1000+"초");
		}
		currentTime = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(currentTime-startTime)/1000+"초");
		System.out.println("finish");
	}
	
	
	
	
	
	public static void getImg_OnlyOne(String my_input_path, String my_output_path, int count , int gab){
		System.out.println("-----------getImg_OnlyOne-----------");
		
		
		video.getIntoPath(my_input_path,my_output_path,600,1,0);
		currentTime = System.currentTimeMillis();
		System.out.println(""+(currentTime-startTime)/1000+"초");
		
		
		//effect
		System.out.println("이펙트 부분 추출 ");
		System.out.println("start");
		
		ArrayList<String> list = video.getList();
		ArrayList<String> name = video.getName();
		String source = list.get(0);
		String destination = output_path+"/effect/";
		
		for(int i = 0 ; i <  count; i ++){
			
			
			if(count%10==0){
				currentTime = System.currentTimeMillis();
				System.out.println(""+(currentTime-startTime)/1000+"초");
			}
			System.out.println(i+" # effect start....");
			effect_all_random(i,source,destination+"/"+name.get(0));
			//System.out.println(source+" # end....");
			
			
		}
		currentTime = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(currentTime-startTime)/1000+"초");
		System.out.println("finish");
		
	}
	/*
	public static void getImg_effectImg(String my_input_path, String my_output_path, int count , int gab){
		System.out.println("-----------main start-----------");
		double[] output = null;
		
		
		//엑셀 부분 추출 
		try{
			output = excel.getExcelSec(xlsx_path);
		}catch(Exception e){
			System.out.println("excel 추출 error");
			e.printStackTrace();
		}
		
		
		//비디오 부분 추출
		try{
			if(output!=null){
				for(int i = 0 ; i < output.length ; i ++){
					//파일,output file path ,시작점(초단위) , 몇 frmae 장 ? , frame과의 grab
					video.getIntoPath(my_input_path,my_output_path,(int)output[i],count,0);

					currentTime = System.currentTimeMillis();
					System.out.println(""+(currentTime-startTime)/1000+"초");
				}
			}
		}catch(Exception e){
			System.out.println("frame 추출 error");
			e.printStackTrace();
		}
		
		
		//종료 멘트
		
		System.out.println("");
		currentTime = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(currentTime-startTime)/1000+"초");
		
		System.out.print("=========== 하이라이트 부분 추출 완료 ===========");
		System.out.println("");
		
		
		//effect 
		System.out.println("이펙트 부분 추출 ");
		System.out.println("start");
		
		ArrayList<String> list = video.getList();
		ArrayList<String> name = video.getName();
		String source = "";
		String destination = "";
		
		for(int i = 0 ; i < list.size(); i ++){
			
			source = list.get(i);
			destination = output_path+"/effect/";
			System.out.println(source+" # start....");
			effect_all(source,destination+"/"+name.get(i));
			//System.out.println(source+" # end....");
			currentTime = System.currentTimeMillis();
			System.out.println(""+(currentTime-startTime)/1000+"초");
		}
		
		System.out.println("finish");
		
	}
	*/
	public static void effect_all(String source , String destination){
		effectImg e = new effectImg();
		
		
		//e.makeResize(source, destination, width, height);
		e.makeResize(source, destination+"_resize.jpg", 400, 300);
		
		//e.makeMosaic(source,destination.png"); //모자이크
		e.makeMosaic(source, destination+"_mosaic.jpg");
		
		//e.makeParagraph(source,destination.png,"내용",width,height);
		e.makeParagraph(source, destination+"_paragraph.jpg", "안녕하세요", 400, 500);
		
		//e.light_black(source, destination, value);
		e.light_black(source, destination+"_black.jpg", 70);
		
		//e.light_white(source, destination, value);
		e.light_white(source, destination+"_white.jpg", 70);
		
		//e.salt_and_pepper(source,destination,100);
		e.salt_and_pepper(source, destination+"_salt_and_pepper.jpg", 100);
		
		//invert(filename,tempFile+"/inver.png");
		e.invert(source, destination+"_invert.jpg");

		e.setBackground(source, destination+"_background.jpg", "C:/Users/Andrew/Desktop/output/temp/backgroundImg.jpg");
		
		//System.out.println("완료");
	}
	
	
	public static void effect_all_random(int i ,String source , String destination){
		
		
		e.makeMosaic_random(source, destination+"_mosaic_"+i+".jpg");
		
		e.makeParagraph_random(source, destination+"_paragraph_"+i+".jpg");
		
		e.light_black_random(source, destination+"_black_"+i+".jpg");
		
		e.light_white_random(source, destination+"_white_"+i+".jpg");
		
		e.salt_and_pepper_random(source, destination+"_salt_and_pepper_"+i+".jpg");
		
		//e.setBackground_random(source, destination+"_background_"+i+".jpg", "C:/Users/Andrew/Desktop/output/temp/backgroundImg.jpg");
		
		//e.setDrawImgCircle(source, destination+"_circle_background_"+i+".jpg", "C:/Users/Andrew/Desktop/output/temp/backgroundImg.jpg");
		
		//e.setCheck(source, destination+"_check_"+i+".jpg");
		
		e.setCheckLine(source, destination+"_check_line_"+i+".jpg");
		
		e.analog(source, destination+"_analog_"+i+".jpg");
		
		e.bubble(source, destination+"_bubble_"+i+".jpg");
		
		//e.dig(source, destination+"_dig_"+i+".jpg");
		//System.out.println("완료");
	}
	public static void effect_test(){
		effectImg e = new effectImg();
		String source = "C:/Users/Andrew/Desktop/output"+"/frame_600_0.png";		
		String destination ="C:/Users/Andrew/Desktop/output/temp";
		
		//소스를 picture 로 해보면 어떻게 될까 ? 
		
		//e.makeResize(source, destination, width, height);
		e.makeResize(source, destination+"/resize.png", 400, 300);
		
		//e.makeMosaic(source,destination.png"); //모자이크
		e.makeMosaic(source, destination+"/mosaic.png");
		
		//e.makeParagraph(source,destination.png,"내용",width,height);
		e.makeParagraph(source, destination+"/paragraph.png", "안녕하세요", 400, 500);
		
		//e.light_black(source, destination, value);
		e.light_black(source, destination+"/black.png", 70);
		
		//e.light_white(source, destination, value);
		e.light_white(source, destination+"/white.png", 70);
		
		//e.salt_and_pepper(source,destination,100);
		e.salt_and_pepper(source, destination+"/salt_and_pepper.png", 100);
		
		//invert(filename,tempFile+"/inver.png");
		e.invert(source, destination+"/invert.png");

		
		System.out.println("완료");
	}
	/*
	public static void excel_video(){
		System.out.println("-----------main start-----------");
		double[] output = null;
		
		
		//엑셀 부분 추출 
		try{
			output = excel.getExcelSec(xlsx_path);
		}catch(Exception e){
			System.out.println("excel 추출 error");
			e.printStackTrace();
		}
		
		
		//비디오 부분 추출
		try{
			if(output!=null){
				for(int i = 0 ; i < output.length ; i ++){
					//파일,output file path ,시작점(초단위) , 몇 frmae 장 ? , frame과의 grab
					video.getIntoPath(mp4_path,output_path,(int)output[i],10,0);
				}
			}
		}catch(Exception e){
			System.out.println("frame 추출 error");
			e.printStackTrace();
		}
		
		
		//종료 멘트
		System.out.println("");
		System.out.println("");
		System.out.print("=========== 하이라이트 부분 추출 완료 ===========");
		System.out.println("");
		
	}
	*/
	
}
